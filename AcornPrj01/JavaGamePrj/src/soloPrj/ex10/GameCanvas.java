package soloPrj.ex10;

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
	private int widthBoard, heightBoard, widthCase, heightCase, widthIntro, heightIntro;
	private Omok[] omoks;
	private OmokBlack omokblack;
	private OmokWhite omokwhite;
	private int[][] location;
	private int index, color, w, h, exitIndex;
	public final int CANVAS_WIDTH, CANVAS_HEIGHT;

	static {

		try {
			imgBoard = ImageIO.read(new File("res/image/omokboard.png"));
			imgCase = ImageIO.read(new File("res/image/case.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "바탕이미지가 없습니다.");
		}

	}

//		50~150,		1000~1100,
	public GameCanvas() {
		gameCanvas = this;
		widthBoard = imgBoard.getWidth(this);
		heightBoard = imgBoard.getWidth(this);
		widthCase = imgBoard.getWidth(this) / 4;
		heightCase = imgBoard.getWidth(this) / 4;
		CANVAS_WIDTH = widthBoard + widthCase * 2;
		CANVAS_HEIGHT = heightBoard;

//		omokblack = new OmokBlack();
		w = h = 20;
		location = new int[w][h];
		omoks = new Omok[50];

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				switch (exitIndex) {
				case ING:
					int x = (int) Math.floor(e.getX() / 40) * 40;
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

		if (exitIndex == ING) {
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (location[i][j] == BLACK)
						confirm(i, j, BLACK);
					if (location[i][j] == WHITE)
						confirm(i, j, WHITE);
				}
			}
		}

	}

	public void check() {

	}

	public void confirm(int x, int y, int color) {

		int winPoint = 0;

		if (x + 5 < w && y + 5 < h && 0 <= y - 5) {

			// 가로 확인
			for (int i = 0; i < 5; i++) {
				if (location[x + i][y] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;

			// 아래 확인
			for (int i = 0; i < 5; i++) {
				if (location[x][y + i] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;

			// 오른쪽 위 대각선 확인
			for (int i = 0; i < 5; i++) {
				if (location[x + i][y - i] == color)
					winPoint++;
			}
			if (winPoint == 5)
				victory(color);
			else
				winPoint = 0;

			// 오른쪽 아래 대각선 확인
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
			JOptionPane.showMessageDialog(GameCanvas.this, "흑(黑)이 승리하였습니다!");
		else if (color == WHITE)
			JOptionPane.showMessageDialog(GameCanvas.this, "백(白)이 승리하였습니다!");

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
