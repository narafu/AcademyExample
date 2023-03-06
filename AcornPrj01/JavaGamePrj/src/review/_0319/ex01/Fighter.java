package review._0319.ex01;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fighter {

	private Image img;
	private int width, height;
	private double x, y, dx, dy, vx, vy;

	public Fighter() {
		try {
			this.img = ImageIO.read(new File("res/image/fighter1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.width = img.getWidth(GameCanvas.getInstance());
		this.height = img.getHeight(GameCanvas.getInstance());
		this.x = 150;
		this.y = 600;
	}

	public void move(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		this.vx = (dx - this.x) / 15;
		this.vy = (dy - this.y) / 15;
	}

	public void update() {
		this.x += this.vx;
		this.y += this.vy;
	}

	public void draw(Graphics g) {
		int dx1 = (int) x - this.width / 2;
		int dy1 = (int) y - this.height / 2;
		int dx2 = (int) x + this.width / 2;
		int dy2 = (int) y + this.height / 2;

		g.drawImage(img, dx1, dy1, dx2, dy2, 0, 0, this.width, this.height, GameCanvas.getInstance());

	}

}
