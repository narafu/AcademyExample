package review._0317.ex09;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fighter {

	private Image img;
	private int w, h;
	private double x, y, dx, dy, vx, vy;

	public Fighter() {

		try {
			img = ImageIO.read(new File("res/image/fighter1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w = img.getWidth(GameCanvas.getInstance());
		h = img.getHeight(GameCanvas.getInstance());
		x = 500;
		y = 500;

	}

	public void draw(Graphics g) {
		int dx1 = (int) x - w / 2;
		int dy1 = (int) y - h / 2;
		int dx2 = (int) x + w / 2;
		int dy2 = (int) y + h / 2;

		g.drawImage(img, dx1, dy1, dx2, dy2, 0, 0, w, h, GameCanvas.getInstance());

	}

	public void move(int dx, int dy) {

		this.dx = dx;
		this.dy = dy;
		vx = (dx - x) / 15;
		vy = (dy - y) / 15;

	}

	public void update() {

		this.x += vx;
		this.y += vy;

	}

}
