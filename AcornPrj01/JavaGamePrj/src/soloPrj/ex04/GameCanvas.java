package soloPrj.ex04;

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
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "바탕이미지가 없습니다.");
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
		omoks = new Omok[100];

		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			int x = rand.nextInt(100) + 50;
			int y = rand.nextInt(100) + 60;
			omoks[index++] = new OmokBlack(x, y);
		}
		for (int i = 0; i < 50; i++) {
			int x = rand.nextInt(100) + 1060;
			int y = rand.nextInt(100) + 575;
			omoks[index++] = new OmokWhite(x, y);
		}

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if ((e.getX() < widthCase) || (widthBoard + widthCase < e.getX()))
					JOptionPane.showMessageDialog(GameCanvas.this, "오목판을 벗어났습니다.");

				else
					switch (exitIndex) {

					case ING:
						// 위치보정
						int x = (int) Math.floor((e.getX()) / 40) * 40;
						int y = (int) Math.floor(e.getY() / 40) * 40;
						int w = (x - 240) / 40;
						int h = y / 40;

						// 중복제거
						if (location[w + 5][h + 5] != 0) {
							JOptionPane.showMessageDialog(GameCanvas.this, "중복입니다.");
							break;
						}

						switch (colorIndex++ % 2 + 1) {
						case BLACK:
							omoks[--index] = new OmokBlack(x, y);
							location[w + 5][h + 5] = BLACK;
							break;
						case WHITE:
							omoks[--index] = new OmokWhite(x, y);
							location[w + 5][h + 5] = WHITE;
							break;
						}

						check();
						break;

					case END:
						JOptionPane.showMessageDialog(GameCanvas.this, "게임이 종료되었습니다.");
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

		// 가변배열(바둑돌)
		if (index == omoks.length) {
			Omok[] temp = new Omok[omoks.length + 50];
			for (int i = 0; i < index; i++)
				temp[i] = omoks[i];
			omoks = temp;
		}

	}

	public void check() {

		// 오목 체크

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

		// 오른쪽 확인
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

		// 아래 확인
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

		// 오른쪽 위 대각선 확인
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

		// 오른쪽 아래 대각선 확인
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

		// 승리
		if (color == BLACK)
			JOptionPane.showMessageDialog(GameCanvas.this, "흑(黑)이 승리하였습니다!");
		else if (color == WHITE)
			JOptionPane.showMessageDialog(GameCanvas.this, "백(白)이 승리하였습니다!");

		// 종료
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
