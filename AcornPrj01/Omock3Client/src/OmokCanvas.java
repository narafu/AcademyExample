
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OmokCanvas extends Canvas implements Receiver {

	private static OmokCanvas omokCanvas;
	private static Image img, imgBoard, imgwinlose, imgBlack, imgWhite, imgRed, imgLoading;
	private final int WHITE = 1;
	private final int BLACK = 2;
	private final int RED = 3;
	private final int EMPTY = 0;
	private final int EDGE = 5;
	private final int LENGTH = 19;
	private Client client;
	private Omok[] omoks;
	private int[][] board;
	private int widthWinlose, heightWinlose, widthStone, heightStone;
	private int exitIndex, omokIndex, imgIndex, top, dx, dy, player, turn;
	private static boolean start;

	static {
		try {
			imgBoard = ImageIO.read(new File("res/image/omokboard.jpg"));
			imgwinlose = ImageIO.read(new File("res/image/winlose.png"));
			imgBlack = ImageIO.read(new File("res/image/omokblack2.png"));
			imgWhite = ImageIO.read(new File("res/image/omokwhite2.png"));
			imgRed = ImageIO.read(new File("res/image/omokred2.png"));
			imgLoading = ImageIO.read(new File("res/image/loading.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		start = false;
	}

	public OmokCanvas() {

		// 네트워크
		client = new Client(this);
		ClientData data = client.connect("192.168.0.21");
		client.start();

		omokCanvas = this;
		widthWinlose = imgwinlose.getWidth(this);
		heightWinlose = imgwinlose.getHeight(this);
		widthStone = imgBlack.getWidth(this);
		heightStone = imgBlack.getHeight(this);

		board = new int[19][19];
		omoks = new Omok[19 * 19];
		player = data.player;

		for (int i = 0; i < omoks.length; i++) {
			omoks[omokIndex++] = new Omok();
			top++;
		}

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				if (exitIndex == 0) {
					if (turn % 3 + 1 == player) {

						if ((e.getX() < 260) || (1020 < e.getX()))
							JOptionPane.showMessageDialog(OmokCanvas.this, "오목판을 벗어났습니다.");

						else {
							// 좌표조정
							int x = e.getX() / 40 * 40;
							int y = e.getY() / 40 * 40;
							dx = (x - 260) / 40;
							dy = y / 40;

							if (board[dy][dx] != EMPTY)
								JOptionPane.showMessageDialog(OmokCanvas.this, "중복입니다");

							else {
								Tapsound.tapSound();
								ClientData data = new ClientData();
								data.x = e.getX();
								data.y = e.getY();
								client.send(data);
							}
						}

					} else
						JOptionPane.showMessageDialog(OmokCanvas.this, "상대방 차례입니다.");

					// 게임종료
				} else {
					JOptionPane.showMessageDialog(OmokCanvas.this, "게임이 종료되었습니다.");
					int result = JOptionPane.showConfirmDialog(OmokCanvas.this, "종료하시겠습니까?");
					if (result == 0)
						System.exit(0);
				}

			}
		});

	}

	@Override
	public void receive(ClientData data) {

		if (data.player == 0)
			start = true;

		if (data.x != 0) {
			if (exitIndex == 0) {

				// 좌표조정
				int x = data.x / 40 * 40;
				int y = data.y / 40 * 40;
				dx = (x - 260) / 40;
				dy = y / 40;

				if (board[dy][dx] == EMPTY) {
					omoks[--top].move(x, y);
					Tapsound.tapSound();
					omokIn();

					// 승패판단
					if (checkRow() || checkCol() || checkUpperDiagonal() || checkLowerDiagonal()) {
						exitIndex++;
						if (turn % 3 + 1 == player)
							winGame();
						else
							loseGame();
					}
					turn++;

				}

				// 게임종료
			} else {
				JOptionPane.showMessageDialog(OmokCanvas.this, "게임이 종료되었습니다.");
				int result = JOptionPane.showConfirmDialog(OmokCanvas.this, "종료하시겠습니까?");
				if (result == 0)
					System.exit(0);
			}
		}
	}

	public static OmokCanvas getInstance() {
		return omokCanvas;
	}

	public void start() {

		Thread gamethread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		gamethread.start();

	}

	public void update() {

		for (int i = 0; i < omokIndex; i++)
			omoks[i].update();
	}

	public void omokIn() {

		switch (turn % 3 + 1) {
		case WHITE:
			board[dy][dx] = WHITE;
			break;
		case BLACK:
			board[dy][dx] = BLACK;
			break;
		case RED:
			board[dy][dx] = RED;
			break;
		}

	}

	public boolean checkRow() {
		for (int y = 0; y < LENGTH; y++) {
			for (int x = 0; x <= LENGTH - EDGE; x++) {
				if (board[y][x] == EMPTY)
					continue;

				int cnt;
				for (cnt = 1; cnt < EDGE; cnt++) {
					if (board[y][x] != board[y][x + cnt])
						break;
				}

				if (cnt != EDGE)
					continue;

				if ((x == LENGTH - EDGE || board[y][x + EDGE] != board[y][x])
						&& (x == 0 || board[y][x - 1] != board[y][x]))
					return true;

			}
		}
		return false;
	}

	public boolean checkCol() {
		for (int x = 0; x < LENGTH; x++) {
			for (int y = 0; y <= LENGTH - EDGE; y++) {
				if (board[y][x] == EMPTY)
					continue;

				int cnt;
				for (cnt = 1; cnt < EDGE; cnt++) {
					if (board[y][x] != board[y + cnt][x])
						break;
				}
				if (cnt != EDGE)
					continue;

				if ((y == LENGTH - EDGE || board[y + EDGE][x] != board[y][x])
						&& (y == 0 || board[y - 1][x] != board[y][x]))
					return true;
			}
		}
		return false;
	}

	public boolean checkUpperDiagonal() {

		for (int x = 0; x <= LENGTH - EDGE; x++) {
			for (int y = EDGE - 1; y < LENGTH; y++) {
				if (board[y][x] == EMPTY)
					continue;

				int cnt;
				for (cnt = 1; cnt < EDGE; cnt++) {
					if (board[y][x] != board[y - cnt][x + cnt])
						break;
				}

				if (cnt != EDGE)
					continue;

				if ((y == EDGE - 1 || x == LENGTH - EDGE || board[y - EDGE][x + EDGE] != board[y][x])
						&& (y == LENGTH - EDGE || x == 0 || board[y + 1][x - 1] != board[y][x]))
					return true;
			}
		}
		return false;
	}

	public boolean checkLowerDiagonal() {
		for (int y = 0; y <= LENGTH - EDGE; y++) {
			for (int x = 0; x <= LENGTH - EDGE; x++) {
				if (board[y][x] == EMPTY)
					continue;

				int cnt;

				for (cnt = 1; cnt < EDGE; cnt++) {
					if (board[y][x] != board[y + cnt][x + cnt])
						break;
				}

				if (cnt != EDGE)
					continue;

				if ((y == LENGTH - EDGE || x == LENGTH - EDGE || board[y + EDGE][x + EDGE] != board[y][x])
						&& (y == 0 || x == 0 || board[y - 1][x - 1] != board[y][x]))
					return true;
			}
		}
		return false;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics bufG = buf.getGraphics();

		if (start == false) {
			bufG.drawImage(imgLoading, 0, 0, 1280, 800, 0, 0, 1280, 800, this);
			g.drawImage(buf, 0, 0, this);
		}

		else if (start == true) {
			bufG.drawImage(imgBoard, 0, 0, this);

			switch (player) {
			case WHITE:
				img = imgWhite;
				break;
			case BLACK:
				img = imgBlack;
				break;
			case RED:
				img = imgRed;
				break;
			}
			bufG.drawImage(img, 50, 150, 200, 300, 0, 0, widthStone, heightStone, this);
			switch (turn % 3 + 1) {
			case WHITE:
				img = imgWhite;
				break;
			case BLACK:
				img = imgBlack;
				break;
			case RED:
				img = imgRed;
				break;
			}
			bufG.drawImage(img, 50, 500, 200, 650, 0, 0, widthStone, heightStone, this);

			for (int i = omokIndex - 1; 0 < i; i--)
				omoks[i].draw(bufG);

			if (exitIndex != 0) {
				bufG.setColor(new Color(0, 0, 0, 125));
				bufG.fillRect(0, 0, 1280, 800);
				bufG.drawImage(imgwinlose, 340, 200, 940, 600, (widthWinlose / 2 * (imgIndex - 1)), 0,
						widthWinlose / 2 * imgIndex, heightWinlose, this);
			}

			g.drawImage(buf, 0, 0, this);
		}
	}

	private void winGame() {
		imgIndex = 1;
	}

	private void loseGame() {
		imgIndex = 2;
	}

}