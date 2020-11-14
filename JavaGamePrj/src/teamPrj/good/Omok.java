package teamPrj.good;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Omok {

	private static final int BLACK = 1;
	private static final int WHITE = 2;
	private static final int RED = 3;
	private static int player;
	private static Image img, imgWhite, imgBlack, imgRed;
	private int width, height, index, speed, color;
	private double x, y, vx, vy, dx, dy;

	static {
		try {
			imgBlack = ImageIO.read(new File("res/image/omokblack.png"));
			imgWhite = ImageIO.read(new File("res/image/omokwhite.png"));
			imgRed = ImageIO.read(new File("res/image/omokred.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		player = 0;

	}

	public Omok() {

		width = imgBlack.getWidth(OmokCanvas.getInstance());
		height = imgBlack.getHeight(OmokCanvas.getInstance());
		speed = 10;

		Random rand = new Random();

		player++;
		this.color = player % 3 + 1;

		switch (color) {
		case BLACK:
			x = rand.nextInt(80) + 70;
			y = rand.nextInt(80) + 70;
			break;
		case WHITE:
			x = rand.nextInt(80) + 1075;
			y = rand.nextInt(80) + 70;
			break;
		case RED:
			x = rand.nextInt(80) + 1075;
			y = rand.nextInt(80) + 575;
			break;
		}

	}

	public void move(int x, int y) {

		this.dx = x + 10;
		this.dy = y;
		double w = dx - this.x;
		double h = dy - this.y;
		double d = (float) Math.sqrt(w * w + h * h);
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

		switch (color) {
		case BLACK:
			img = imgBlack;
			break;
		case WHITE:
			img = imgWhite;
			break;
		case RED:
			img = imgRed;
			break;
		}

		g.drawImage(img, dx1, dy1, dx2 + index, dy2 + index, 0, 0, width, height, OmokCanvas.getInstance());
	}

}
