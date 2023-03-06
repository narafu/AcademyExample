package soloPrj.ex03;

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
	private OmokBlack omokBlack;
	private OmokWhite omokWhite;
	private int[][] location;
	private int index, colorIndex, row, cross, exitIndex;

	static {

		try {
			imgBoard = ImageIO.read(new File("res/image/omokboard.png"));
			imgCase = ImageIO.read(new File("res/image/omokcase.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "�����̹����� �����ϴ�.");
		}

	}

//		50~150,		1000~1100,
	public GameCanvas() {
		gameCanvas = this;
		widthBoard = imgBoard.getWidth(this);
		heightBoard = imgBoard.getHeight(this);
		widthCase = imgCase.getWidth(this) / 2;
		heightCase = imgCase.getHeight(this) / 2;
		setSize(widthBoard + widthCase * 2, heightBoard);

		row = cross = 19 + 5 + 5;
		location = new int[row][cross];

		// omokblack = new OmokBlack();
		omoks = new Omok[50];

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if ((e.getX() < widthCase) || (widthBoard + widthCase < e.getX()))
					JOptionPane.showMessageDialog(GameCanvas.this, "�������� ������ϴ�.");

				else
					switch (exitIndex) {

					case ING:
						// ��ġ����
						int x = (int) Math.floor((e.getX()) / 40) * 40;
						int y = (int) Math.floor(e.getY() / 40) * 40;
						int w = (x - 240) / 40;
						int h = y / 40;

						// �ߺ�����
						if (location[w + 5][h + 5] != 0) {
							JOptionPane.showMessageDialog(GameCanvas.this, "�ߺ��Դϴ�.");
							break;
						}

						switch (colorIndex++ % 2 + 1) {
						case BLACK:
							omoks[index++] = new OmokBlack(x, y);
							location[w + 5][h + 5] = BLACK;
							break;
						case WHITE:
							omoks[index++] = new OmokWhite(x, y);
							location[w + 5][h + 5] = WHITE;
							break;
						}

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

		// �����迭(�ٵϵ�)
		if (index == omoks.length) {
			Omok[] temp = new Omok[omoks.length + 50];
			for (int i = 0; i < index; i++)
				temp[i] = omoks[i];
			omoks = temp;
		}

	}

	public void check() {

		// ���� üũ

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cross; j++) {
				if (location[i][j] == BLACK)
					confirm(i, j, BLACK);
				if (location[i][j] == WHITE)
					confirm(i, j, WHITE);
			}
		}
	}

	public void confirm(int x, int y, int color) {

		int winPoint = 0;

		// ������ Ȯ��
		for (int i = 0; i < 5; i++) {
			if (location[x + i][y] == color)
				winPoint++;
		}

		if ((location[x - 1][y] == color) || (location[x + 5][y] == color))
			winPoint--;

		if (winPoint == 5)
			victory(color);
		else
			winPoint = 0;

		// �Ʒ� Ȯ��
		for (int i = 0; i < 5; i++) {
			if (location[x][y + i] == color)
				winPoint++;
		}

		if ((location[x][y - 1] == color) || (location[x][y + 5] == color))
			winPoint--;

		if (winPoint == 5)
			victory(color);
		else
			winPoint = 0;

		// ������ �� �밢�� Ȯ��
		for (int i = 0; i < 5; i++) {
			if (location[x + i][y - i] == color)
				winPoint++;
		}

		if ((location[x - 1][y + 1] == color) || (location[x + 5][y - 5] == color))
			winPoint--;

		if (winPoint == 5)
			victory(color);
		else
			winPoint = 0;

		// ������ �Ʒ� �밢�� Ȯ��
		for (int i = 0; i < 5; i++) {
			if (location[x + i][y + i] == color)
				winPoint++;
		}

		if ((location[x - 1][y - 1] == color) || (location[x + 5][y + 5] == color))
			winPoint--;

		if (winPoint == 5)
			victory(color);
		else
			winPoint = 0;

	}

	public void victory(int color) {

		// �¸�
		if (color == BLACK)
			JOptionPane.showMessageDialog(GameCanvas.this, "��(��)�� �¸��Ͽ����ϴ�!");
		else if (color == WHITE)
			JOptionPane.showMessageDialog(GameCanvas.this, "��(��)�� �¸��Ͽ����ϴ�!");

		// ����
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

		bufG.drawImage(imgCase, 0, 0, widthCase, heightCase, this);
		bufG.drawImage(imgBoard, widthCase, 0, widthBoard, heightBoard, this);
		bufG.drawImage(imgCase, widthCase + widthBoard, heightBoard - heightCase, widthCase, heightCase, this);

		for (int i = 0; i < index; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);

	}

}
