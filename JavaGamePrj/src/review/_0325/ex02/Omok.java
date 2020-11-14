package review._0325.ex02;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Omok {

	private static final int BLACK;
	private static final int WHITE;
	private static Image img, imgWhite, imgBlack;
	private static boolean isblackTurn;
	private static int width, height;
	private int color, x, y;

	static {

		isblackTurn = true;
		BLACK = 1;
		WHITE = 2;

		try {
			imgBlack = ImageIO.read(new File("res/image/omokblack.png"));
			imgWhite = ImageIO.read(new File("res/image/omokwhite.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = imgBlack.getWidth(OmokCanvas.getInstance());
		height = imgBlack.getHeight(OmokCanvas.getInstance());
	}

	public Omok() {
		this(0, 0);
		color = BLACK;
	}

	public Omok(int x, int y) {

		this.x = x;
		this.y = y;

		isblackTurn = !isblackTurn;
		if (isblackTurn)
			color = BLACK;
		else
			color = WHITE;

	}

	public void draw(Graphics g) {

		img = imgBlack;

		if (color == WHITE)
			img = imgWhite;

		g.drawImage(img, x - width / 2, y - height / 2, OmokCanvas.getInstance());

	}

}
