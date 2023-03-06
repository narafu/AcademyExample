package review._0323.ex02;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import review._0321.ex01.GameCanvas;

public class Fighter implements Movable {

	private static Image img;
	private double x, y, vx, vy, dx, dy;
	private int speed, width, height, imageIndex;

	static {
		try {
			img = ImageIO.read(new File("res/image/fighter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Fighter() {
		x = 250;
		y = 400;
		speed = 10;
		imageIndex = 3;
		width = img.getWidth(GameCanvas.getInstance()) / 7;
		height = img.getHeight(GameCanvas.getInstance());

	}

	public void moveLeft() {
		if (50 < x)
			this.x -= speed;
		if (0 < imageIndex)
			imageIndex--;
	}

	public void moveRight() {
		if (x < 450)
			this.x += speed;
		if (imageIndex < 6)
			imageIndex++;
	}

	public void moveUp() {
		if (50 < y)
			this.y -= speed;
	}

	public void moveDown() {
		if (y < 450)
			this.y += speed;
	}

	@Override
	public void dateUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		int dx1 = (int) x - width / 2;
		int dy1 = (int) y - height / 2;
		int dx2 = (int) x + width / 2;
		int dy2 = (int) y + height / 2;

		g.drawImage(img, dx1, dy1, dx2, dy2, width * imageIndex, 0, width * (imageIndex + 1), height,
				GameCanvas.getInstance());

	}

	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}

}
