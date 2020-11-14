package review._0321.ex01;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fighter implements Movable {

	private static Image img;
	private int width, height;
	private double x, y, vx, vy, dx, dy, w, h, d;
	private int speed, imgIndex;

	static {
		try {
			img = ImageIO.read(new File("res/image/fighter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Fighter() {

		width = img.getWidth(GameCanvas.getInstance()) / 7;
		height = img.getHeight(GameCanvas.getInstance());
		x = 180;
		y = 700;
		speed = 10;
		imgIndex = 3;

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

	@Override
	public void dateUp() {
		x += vx;
		y += vy;

		if (Math.abs(dx - x) <= Math.abs(vx)) {
			vx = 0;
			vy = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		int dx1 = (int) x - width / 2;
		int dy1 = (int) y - height / 2;
		int dx2 = (int) x + width / 2;
		int dy2 = (int) y + height / 2;
		g.drawImage(img, dx1, dy1, dx2, dy2, width * imgIndex, 0, width * (imgIndex + 1), height,
				GameCanvas.getInstance());
	}

	public void setImgIndex(int imgIndex) {
		this.imgIndex = imgIndex;
	}

	public void moveLeft() {
		if (width / 2 < x)
			x -= speed;
		if (0 < imgIndex)
			imgIndex--;
	}

	public void moveRight() {
		if (x < 360 - width / 2)
			x += speed;
		if (imgIndex < 6)
			imgIndex++;
	}

	public void moveUp() {
		if (height / 2 < y)
			y -= speed;
	}

	public void moveDown() {
		if (y < 800 - height / 2)
			y += speed;
	}

	public void fire() {

	}

}
