package review._0318.ex05;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Space {

	private Image img;
	private double y;

	public Space() {

		try {
			img = ImageIO.read(new File("res/image/space.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y = -400;

	}

	public void update() {
		this.y += 1;

	}

	public void draw(Graphics g) {
		g.drawImage(img, 0, (int) y, GameCanvas.getInstance());

	}

}
