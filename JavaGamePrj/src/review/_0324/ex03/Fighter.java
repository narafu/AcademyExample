package review._0324.ex03;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import review._0321.ex01.GameCanvas;

public class Fighter implements Movable {

	private static Image img;
	private static final int NORTH = 1;
	private static final int EAST = 2;
	private static final int SOUTH = 4;
	private static final int WEST = 8;
	private double x, y;
	private int width, height, speed, imgIndex, direction;

	static {
		try {
			img = ImageIO.read(new File("res/image/fighter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Fighter() {

		width = img.getWidth(GameCanvas.getInstance()) / 7;
		height = img.getHeight(GameCanvas.getInstance());
		x = 250;
		y = 800;
		speed = 10;
		imgIndex = 3;
	}

	@Override
	public void dateUp() {

	}

	@Override
	public void paint(Graphics g) {

		if ((direction & NORTH) == NORTH)
			y -= speed;
		if ((direction & EAST) == EAST)
			x += speed;
		if ((direction & SOUTH) == SOUTH)
			y += speed;
		if ((direction & WEST) == WEST)
			x -= speed;

		int dx1 = (int) x - width / 2;
		int dy1 = (int) y - height / 2;
		int dx2 = (int) x + width / 2;
		int dy2 = (int) y + height / 2;

		g.drawImage(img, dx1, dy1, dx2, dy2, width * imgIndex, 0, width * (imgIndex + 1), height,
				GameCanvas.getInstance());
	}

	public void move(int direction) {
		this.direction = direction;

	}

}
