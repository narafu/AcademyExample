package review._0319.ex01;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Space {

	private Image img;
	private double y, dy, vy;

	public Space() {

		try {
			this.img = ImageIO.read(new File("res/image/space.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.y = -400;
	}

	public void update() {
		this.y += 1;

	}

	public void draw(Graphics g) {
		g.drawImage(img, 0, (int) this.y, GameCanvas.getInstance());

	}

}