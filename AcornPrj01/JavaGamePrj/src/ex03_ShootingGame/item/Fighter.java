package ex03_ShootingGame.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ex03_ShootingGame.ui.ShootingCanvas;

public class Fighter implements Movable {

	// 부모(GameUnit)로부터 물려 받는다.

	public static final int N = 1;
	public static final int E = 2;
	public static final int S = 4;
	public static final int W = 8;
	private static Image img;
	private int width, height, imgindex, speed;
	private double x, y, vx, vy, dx, dy, w, h, d;
	private int direction;

	public void setImgindex(int imgindex) {
		this.imgindex = imgindex;
	}

	static {
		try {
			img = ImageIO.read(new File("res/image/fighter.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Fighter() {
		width = img.getWidth(ShootingCanvas.getInstance()) / 7;
		height = img.getHeight(ShootingCanvas.getInstance());
		x = 300;
		y = 900;
		imgindex = 3;
		speed = 10;
	}

	public void move(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
		w = dx - x;
		h = dy - y;
		d = Math.sqrt(w * w + h * h);
		vx = w / d * speed;
		vy = h / d * speed;

	}

	public void dateUp() {
		this.x += vx;
		this.y += vy;

		if (Math.abs(dx - x) <= Math.abs(vx)) {
			vx = 0;
			vy = 0;
		}

//		if ((dx - speed <= x) && (x <= dx + speed) && (dy - speed <= y) && (y <= dy + speed)) {
//			vx = 0;
//			vy = 0;
//		}

	}

	public void draw(Graphics g) {

		if ((direction & N) == N)
			if (height / 2 < y)
				y -= speed;
		if ((direction & E) == E)
			if (x < 600 - width)
				x += speed;
		if ((direction & S) == S)
			if (y < 1000 - height)
				y += speed;
		if ((direction & W) == W)
			if (width / 2 < x)
				x -= speed;

		int offsetX = width / 2;
		int offsetY = height / 2;
		int dx1 = (int) x - offsetX;
		int dy1 = (int) y - offsetY;
		int dx2 = (int) x + offsetX;
		int dy2 = (int) y + offsetY;

		g.drawImage(img, dx1, dy1, dx2, dy2, imgindex * width, 0, (imgindex + 1) * width, height,
				ShootingCanvas.getInstance());
	}

//	public void moveLeft() {
//		if (width / 2 < x)
//			x -= speed;
//		if (0 < imgindex)
//			imgindex--;
//	}
//	public void moveUp() {
//		if (height / 2 < y)
//			y -= speed;
//	}
//	public void moveRight() {
//		if (x < 360 - width / 2)
//			x += speed;
//		if (imgindex < 6)
//			imgindex++;
//	}
//	public void moveDown() {
//		if (y < 780 - height / 2)
//			y += speed;
//	}
	public void move(int direction) {
		this.direction = direction;
	}

	public Missile fire() {
		// TODO Auto-generated method stub
		return null;
	}
}
