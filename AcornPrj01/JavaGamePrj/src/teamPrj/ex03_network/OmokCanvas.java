package teamPrj.ex03_network;

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
	private Omok omok;
	private Omok[] omoks;
	private int[][] board;
	private boolean color;
	private int widthBoard, heightBoard, widthCase, heightCase, widthwinlose, heightwinlose;
	private int exitIndex, omokIndex, top, dx, dy;
	private final int EMPTY = 0;
	private final int EDGE = 5;
	private final int LENGTH = 19;
	private final int ING = 0;
	private final int END = 1;
	private Client client;
	private boolean isBlack;

	static {
		try {
			imgBoard = ImageIO.read(new File("res/image/omokboard.png"));
			imgCase = ImageIO.read(new File("res/image/omokcase.png"));
//			imgwinlose = ImageIO.read(new File("res/image/winlose.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public OmokCanvas() {

		// 네트워크
		client = new Client(this);
		ClientData data = client.connect("192.168.0.15");
		client.start();
		isBlack = data.isBlack;

		omokCanvas = this;
		widthBoard = imgBoard.getWidth(this);
		heightBoard = imgBoard.getHeight(this);
		widthCase = imgCase.getWidth(this) / 2;
		heightCase = imgCase.getHeight(this) / 2;
//		widthwinlose = imgwinlose.getWidth(this);
//		heightwinlose = imgwinlose.getHeight(this);
		setSize(widthBoard + widthCase * 2, heightBoard);

		color = true;
		board = new int[19][19];
		omoks = new Omok[19 * 19];
		for (int i = 0; i < omoks.length; i++) {
			omoks[omokIndex++] = new Omok();
			top++;
		}

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {

				ClientData data = new ClientData();
				data.isBlack = isBlack;

				switch (exitIndex) {

				case ING:
					int x = (int) (Math.ceil(e.getX() / 40) * 40);
					int y = (int) (Math.ceil(e.getY() / 40) * 40);

					client.send(data);

					dx = (x - 240) / 40;
					dy = y / 40;

					if ((e.getX() < widthCase) || (widthBoard + widthCase < e.getX()))
						JOptionPane.showMessageDialog(OmokCanvas.this, "오목판을 벗어났습니다.");

					else if (board[dy][dx] == EMPTY) {
						color = !color;
						omoks[--top].move(x, y);
						omokIn();

					} else {

						JOptionPane.showMessageDialog(OmokCanvas.this, "중복입니다");

					}

					if (checkRow() || checkCol() || checkUpperDiagonal() || checkLowerDiagonal()) {
						if (color == false)
							JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "흑(黑)이 승리하였습니다!");
						if (color == true)
							JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "백(白)이 승리하였습니다!");
						exitIndex++;
					}
					break;

				case END:
					JOptionPane.showMessageDialog(OmokCanvas.this, "게임이 종료되었습니다.");
					System.exit(0);
					break;
				}
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
		// 검은
		if (color == true)
			board[dy][dx] = 1;
		// 흰
		if (color == false)
			board[dy][dx] = 2;
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

//		if (exitIndex == 1)
//			bufG.drawImage(imgwinlose, x, y, this);

		for (int i = 0; i < omokIndex; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);
	}

	@Override
	public void receive(ClientData data) {

		System.out.println("yyyyyyyyyyyyyyyyyyyy");

	}
}
