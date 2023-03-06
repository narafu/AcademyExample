package soloPrj.ex07;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Omok {

	private static final int BLACK = 1;
	private static final int WHITE = 2;
	private static Image img, imgWhite, imgBlack;
	private static boolean isblackTurn;
	private int width, height, color;
	private double x, y;

	static {

		isblackTurn = true;
		try {
			imgBlack = ImageIO.read(new File("res/image/omokblack.png"));
			imgWhite = ImageIO.read(new File("res/image/omokwhite.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Omok() {
		width = imgBlack.getWidth(OmokCanvas.getInstance());
		height = imgBlack.getHeight(OmokCanvas.getInstance());

		Random rand = new Random();
		if (isblackTurn) {
			this.color = BLACK;
			x = rand.nextInt(80) + 70;
			y = rand.nextInt(80) + 70;

		} else {
			this.color = WHITE;
			x = rand.nextInt(80) + 1075;
			y = rand.nextInt(80) + 580;
		}

		isblackTurn = !isblackTurn;

	}

	public void move(int x, int y) {

		this.x = x + 10;
		this.y = y;
	}

	public void update() {

	}

	public void draw(Graphics g) {

		img = imgBlack;

		if (color == WHITE)
			img = imgWhite;

		g.drawImage(img, (int) x, (int) y, OmokCanvas.getInstance());

	}

}
