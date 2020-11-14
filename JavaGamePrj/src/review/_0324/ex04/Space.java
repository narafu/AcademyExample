package review._0324.ex04;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Space implements Movable {

	private static Image img;
	private double x, y, vx, vy;
	private int width, height, imgIndex;

	static {
		try {
			img = ImageIO.read(new File("res/image/space.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Space() {

		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());

		x = 0;
		y = 1000 - height;
		vy = 1;

	}

	@Override
	public void dateUp() {

//		y += vy;

	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, 0, (int) y, 500, 1000, 0, 0, width, height, GameCanvas.getInstance());

	}

}
