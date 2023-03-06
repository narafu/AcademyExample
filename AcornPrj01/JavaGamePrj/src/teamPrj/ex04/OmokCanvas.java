package teamPrj.ex04;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OmokCanvas extends Canvas {

	private static OmokCanvas omokCanvas;
	private Image img;
	private Omok omok;
	private Omok[] omoks;
	private int[][] board;
	private boolean color;
	// 오목을 추가할 위치를 기억하기 위한 변수 omokIndex를 추가하고 0으로 초기화해주세요.
	private int width, height, omokIndex, top, dx, dy;
	private final int EMPTY = 0;
	private final int EDGE = 5;
	private final int LENGTH = 19;

	public OmokCanvas() {
		try {
			img = ImageIO.read(new File("res/image/omokboard.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		board = new int[19][19];
		omokCanvas = this;
		omoks = new Omok[100];
		width = img.getWidth(this);
		height = img.getHeight(this);
		setSize(width, height);
		top = -1;
		color = true;
		// 배열초기화
		for (int x = 0; x < 19; x++)
			for (int y = 0; y < 19; y++)
				board[x][y] = 0;

		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			int x = rand.nextInt(20) + 10;
			int y = rand.nextInt(20) + 10;
			omoks[omokIndex++] = new Omok(x, y);
			top++;
		}

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				x = (int) (Math.floor(x / 40) * 40);
				y = (int) (Math.floor(y / 40) * 40);
				dx = x / 40;
				dy = y / 40;
				color = !color;
				try {
					omok = omoks[top--];
					omok.move(x, y);
					omokIn();
//					System.out.println(dx);
//					System.out.println(dy);
//					for (int i = 0; i < 19; i++) {
//						for (int j = 0; j < 19; j++)
//							System.out.printf("%2d", board[i][j]);
//						System.out.println();
//					}
//					System.out.println();
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "더 이상 오목알이 없습니다.");
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
					update(); // 점진적 변화
					repaint(); // 초당 60번씩 다시 그린다.
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
		if (checkRow() || checkCol() || checkUpperDiagonal() || checkLowerDiagonal()) {
			if (color == true)
				JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "검은돌 승리");
			if (color == false)
				JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "흰돌 승리");
		}
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
		bufG.drawImage(img, 0, 0, this);
		for (int i = 0; i < omokIndex; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);
	}
}
