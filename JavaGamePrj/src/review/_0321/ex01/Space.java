package review._0321.ex01;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Space implements Movable {

	private static Image img;
	private int width, height, imgIndex;
	private double y, vy;

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
		y = 800 - height;
		vy = 1;
		imgIndex = 0;
	}

	@Override
	public void dateUp() {
		y += vy;
		if (y % height == 0)
			imgIndex++;
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, 0, (int) y - height * imgIndex, GameCanvas.getInstance());
		g.drawImage(img, 0, (int) y - height * (imgIndex - 1), GameCanvas.getInstance());
	}

}
