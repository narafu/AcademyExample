package review._0317.ex08;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {

	private Image img;

	private int width, height;
	private double x, y;

	public Enemy() {
		try {
			img = ImageIO.read(new File("res/image/alien1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		width = img.getWidth(GameCanvas.getInstance()) / 3;
		height = img.getHeight(GameCanvas.getInstance());
		x = 200;
		y = 200;

	}

	public void draw(Graphics g) {
		int dx1 = (int) x - width / 2;
		int dy1 = (int) y - height / 2;
		int dx2 = (int) x + width / 2;
		int dy2 = (int) y + height / 2;

		g.drawImage(img, dx1, dy1, dx2, dy2, 0, 0, width, height, GameCanvas.getInstance());

	}

	public void move(int x, int y) {

		this.x = x;
		this.y = y;

	}

}
