package teamPrj.ex02;

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
	private static boolean isblackTurn, changeIndex;
	private int width, height, color, index;
	private double x, y;
	private double vx;
	private double vy;
	private double dx;
	private double dy;
	private int speed;

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
		changeIndex = false;
		index = 0;
		speed = 10;
		Random rand = new Random();
		if (isblackTurn) {
			this.color = BLACK;
			x = rand.nextInt(80) + 70;
			y = rand.nextInt(80) + 70;

		} else {
			this.color = WHITE;
			x = rand.nextInt(80) + 1075;
			y = rand.nextInt(80) + 575;
		}

		isblackTurn = !isblackTurn;

	}

	public void move(int x, int y) {
		this.dx = x + 10; // 목표점
		this.dy = y;
		double w = dx - this.x;
		double h = dy - this.y;
		double d = (float) Math.sqrt(w * w + h * h); // sqrt 루트
		vx = (w / d) * speed;
		vy = (h / d) * speed;
		index = 20;
	}

	public void update() {

		if (Math.abs(dx - x) < Math.abs(vx) && Math.abs(dy - y) < Math.abs(vy)) {
			vx = 0;
			vy = 0;
			this.x = dx;
			this.y = dy;
			index = 0;
		}

		this.x += vx;
		this.y += vy;

	}

	public void draw(Graphics g) {
		int dx1 = (int) (x);
		int dy1 = (int) (y);
		int dx2 = (int) (x + width);
		int dy2 = (int) (y + height);
		img = imgBlack;

		if (color == WHITE)
			img = imgWhite;

		g.drawImage(img, dx1, dy1, dx2 + index, dy2 + index, 0, 0, width, height, OmokCanvas.getInstance());
	}

}
