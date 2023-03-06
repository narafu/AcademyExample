package soloPrj.ex01;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class GameCanvas extends Canvas {

	private static final int BLACK = 1;
	private static final int WHITE = 2;
	private static final int ING = 0;
	private static final int END = 1;
	private static Image imgBoard, imgCase;
	private static GameCanvas gameCanvas;
	private int widthBoard, heightBoard, widthCase, heightCase;
	private Omok[] omoks;
	private OmokBlack omokblack;
	private OmokWhite omokwhite;
	private int[][] location;
	private int index, color, w, h, exitIndex;

	static {

		try {
			imgBoard = ImageIO.read(new File("res/image/omokboard.png"));
			imgCase = ImageIO.read(new File("res/image/case.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "�����̹����� �����ϴ�.");
		}

	}

//		50~150,		1000~1100,
	public GameCanvas() {
		gameCanvas = this;
		widthBoard = imgBoard.getWidth(this);
		heightBoard = imgBoard.getWidth(this);
		widthCase = imgBoard.getWidth(this) / 4;
		heightCase = imgBoard.getWidth(this) / 4;
		setSize(widthBoard + widthCase * 2, heightBoard);

//		omokblack = new OmokBlack();
		w = h = 20;
		location = new int[w][h];
		omoks = new Omok[50];

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				switch (exitIndex) {
				case ING:
					int x = (int) Math.floor(e.getX() / 40) * 40 - 10;
					int y = (int) Math.floor(e.getY() / 40) * 40;
					int row = (x - widthCase) / 40;
					int cross = y / 40;

					switch (color % 2 + 1) {
					case BLACK:
						omoks[index++] = new OmokBlack(x, y);
						location[row][cross] = BLACK;
						break;
					case WHITE:
						omoks[index++] = new OmokWhite(x, y);
						location[row][cross] = WHITE;
						break;
					}
					color++;
					check();
					break;
				case END:
					JOptionPane.showMessageDialog(GameCanvas.this, "������ ����Ǿ����ϴ�.");
					break;
				}
			}

		});

	}

	public static GameCanvas getInstance() {
		return gameCanvas;
	}

	public void start() {

		Thread gameThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					dateUp();
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						JOptionPane.showMessageDialog(GameCanvas.this, "thread error");
					}
				}
			}
		});
		gameThread.start();
	}

	public void dateUp() {

//		for (int i = 0; i < index; i++)
//			omoks[i].dateUp();

	}

	public void check() {

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (location[i][j] == BLACK)
					confirm(i, j, BLACK);
				if (location[i][j] == WHITE)
					confirm(i, j, WHITE);
			}
		}

	}

	public void confirm(int x, int y, int color) {

		int winPoint = 0;

		if (x + 5 < w && y + 5 < h && 0 <= y - 5) {

			// ���� Ȯ��
			for (int i = 0; i < 5; i++) {
				if (location[x + i][y] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;

			// �Ʒ� Ȯ��
			for (int i = 0; i < 5; i++) {
				if (location[x][y + i] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;

			// ������ �� �밢�� Ȯ��
			for (int i = 0; i < 5; i++) {
				if (location[x + i][y - i] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;

			// ������ �Ʒ� �밢�� Ȯ��
			for (int i = 0; i < 5; i++) {
				if (location[x + i][y + i] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;
		}

	}

	public void victory(int color) {

		if (color == BLACK)
			JOptionPane.showMessageDialog(GameCanvas.this, "��(��)�� �¸��Ͽ����ϴ�!");
		else if (color == WHITE)
			JOptionPane.showMessageDialog(GameCanvas.this, "��(��)�� �¸��Ͽ����ϴ�!");

		exitIndex = END;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics bufG = buf.getGraphics();

		bufG.drawImage(imgBoard, widthCase, 0, widthBoard, heightBoard, this);
		bufG.drawImage(imgCase, 0, 0, widthCase, heightCase, this);
		bufG.drawImage(imgCase, widthBoard + widthCase, heightBoard - heightCase, widthCase, heightCase, this);

		for (int i = 0; i < index; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);

	}

}
