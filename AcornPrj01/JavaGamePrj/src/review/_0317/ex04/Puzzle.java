package review._0317.ex04;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Puzzle {

	private Image img;
	private int width, height;
	private int sx, sy;

	public Puzzle(int index) {

		try {
			img = ImageIO.read(new File("res/image/dragon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		width = img.getWidth(GameCanvas.getInstance()) / 3;
		height = img.getHeight(GameCanvas.getInstance()) / 2;

	}

	public void draw(Graphics g) {

	}
}