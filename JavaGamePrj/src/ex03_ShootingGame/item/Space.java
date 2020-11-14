package ex03_ShootingGame.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ex03_ShootingGame.ui.ShootingCanvas;

public class Space implements Movable {

	private Image img;
	private double y, vy;
	private int width, height, imgIndex;

	public Space() {
		try {
			img = ImageIO.read(new File("res/image/space.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = img.getWidth(ShootingCanvas.getInstance());
		height = img.getHeight(ShootingCanvas.getInstance());
		y = 1000 - height;
		vy = 1;
		imgIndex = 0;
	}

	public void dateUp() {
		this.y += vy;
//		if (y % height == 0 && y != 0)
//			imgIndex++;

		if (y == 1200)
			y = 1000 - height;
		System.out.println(y);
	}

	public void draw(Graphics g) {
		g.drawImage(img, 0, (int) y, 600, 1000, 0, 0, width, height, ShootingCanvas.getInstance());
		g.drawImage(img, 0, (int) y - height, 600, 1000, 0, 0, width, height, ShootingCanvas.getInstance());
	}
}
