package review._0318.ex03;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fighter {

	private Image img;
	private int width, height;
	private double x, y;

	public Fighter() {

		try {
			img = ImageIO.read(new File("res/image/fighter1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());
		x = 250;
		y = 250;
	}

	public void draw(Graphics g) {
		int offsetX = width / 2;
		int offsetY = height / 2;
		int dx1 = (int) x - offsetX;
		int dy1 = (int) y - offsetY;
		int dx2 = (int) x + offsetX;
		int dy2 = (int) y + offsetY;

		g.drawImage(img, dx1, dy1, dx2, dy2, 0, 0, width, height, GameCanvas.getInstance());
	}
}
