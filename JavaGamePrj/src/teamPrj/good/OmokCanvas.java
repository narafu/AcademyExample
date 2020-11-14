package teamPrj.good;

import java.awt.Canvas;
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
	private static Image imgBoard, imgCase, imgwinlose;
	private final int BLACK = 1;
	private final int WHITE = 2;
	private final int BLUE = 3;
	private final int EMPTY = 0;
	private final int EDGE = 5;
	private final int LENGTH = 19;
	private final int ING = 0;
	private final int END = 1;
	private Client client;
	private Omok[] omoks;
	private int[][] board;
	private int widthBoard, heightBoard, widthCase, heightCase, widthWinlose, heightWinlose;
	private int exitIndex, omokIndex, imgIndex, top, dx, dy, player, turn;

	static {
		try {
			imgBoard = ImageIO.read(new File("res/image/omokboard.png"));
			imgCase = ImageIO.read(new File("res/image/omokcase.png"));
			imgwinlose = ImageIO.read(new File("res/image/winlose.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public OmokCanvas() {

		// 네트워크
		client = new Client(this);
		ClientData data = client.connect("192.168.0.32");
		client.start();

		omokCanvas = this;
		widthBoard = imgBoard.getWidth(this);
		heightBoard = imgBoard.getHeight(this);
		widthCase = imgCase.getWidth(this) / 2;
		heightCase = imgCase.getHeight(this) / 2;
		widthWinlose = imgwinlose.getWidth(this) / 4;
		heightWinlose = imgwinlose.getHeight(this) / 2;

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

				System.out.printf("turn: %d, player: %d\n", turn, player);

				if (turn % 3 + 1 == player) {

					if ((e.getX() < widthCase) || (widthBoard + widthCase < e.getX()))
						JOptionPane.showMessageDialog(OmokCanvas.this, "오목판을 벗어났습니다.");

					else {

						int x = (int) (Math.ceil(e.getX() / 40) * 40);
						int y = (int) (Math.ceil(e.getY() / 40) * 40);
						dx = (x - 240) / 40;
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

			}
		});

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

		switch (player) {
		case BLACK:
			board[dy][dx] = BLACK;
			break;
		case WHITE:
			board[dy][dx] = WHITE;
			break;
		case BLUE:
			board[dy][dx] = BLUE;
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

		bufG.drawImage(imgBoard, widthCase, 0, this);

		bufG.drawImage(imgCase, 0, 0, widthCase, heightCase, this);
		bufG.drawImage(imgCase, widthCase + widthBoard, heightBoard - heightCase, widthCase, heightCase, this);
		bufG.drawImage(imgCase, widthCase + widthBoard, 0, widthCase, heightCase, this);

		if (exitIndex == 1)
			bufG.drawImage(imgwinlose, 1280 / 2 - widthWinlose, 800 / 2 - heightWinlose, 1280 / 2 + widthWinlose,
					800 / 2 + heightWinlose, widthWinlose * (imgIndex - 1), 0, widthWinlose * imgIndex, heightWinlose,
					this);

		for (int i = omokIndex - 1; 0 < i; i--)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);
	}

	@Override
	public void receive(ClientData data) {

		if (data.x != 0) {

			switch (exitIndex) {

			case ING:

				int x = (int) (Math.ceil(data.x / 40) * 40);
				int y = (int) (Math.ceil(data.y / 40) * 40);

				dx = (x - 240) / 40;
				dy = y / 40;

				if (board[dy][dx] == EMPTY) {
					omoks[--top].move(x, y);
					turn++;
					omokIn();
				}

				if (checkRow() || checkCol() || checkUpperDiagonal() || checkLowerDiagonal()) {

					// imgIndex 1 승리 2 패배
					switch (player) {
					case BLACK:
						System.out.println("블랙 승리");
						if (player == BLACK)
							imgIndex = 1;
						else
							imgIndex = 2;

						break;
					case WHITE:
						System.out.println("화이트 승리");
						if (player == WHITE)
							imgIndex = 1;
						else
							imgIndex = 2;
						break;

					case BLUE:
						System.out.println("블루 승리");
						if (player == BLUE)
							imgIndex = 1;
						else
							imgIndex = 2;
						break;
					}
					exitIndex++;
				}
				break;

			case END:
				JOptionPane.showMessageDialog(OmokCanvas.this, "게임이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}

	}
}