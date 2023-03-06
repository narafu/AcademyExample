package teamPrj.ex00;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player implements Movable {

	private static final int NORTH = 1;
	private static final int EAST = 2;
	private static final int SOUTH = 4;
	private static final int WEST = 8;
	private static Image player;
	private double x, y;
	private int width, height, imgIndexX, imgIndexY;
	private int speed, direction, delay;

	static {
		try {
			player = ImageIO.read(new File("res/image/man.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player() {
		width = player.getWidth(GameCanvas.getInstance()) / 4;
		height = player.getHeight(GameCanvas.getInstance()) / 3;
		x = 30;
		y = 30;
		delay = 10;
		speed = 3;
	}

	@Override
	public void update() {
		lockup();
	}

	@Override
	public void draw(Graphics g) {

		if (direction == NORTH) {
			imgIndexX = 3;
			if (--delay == 0) {
				imgIndexY++;
				imgIndexY %= 3;
				delay = 10;
			}
			y -= speed;
		}
		if (direction == EAST) {
			imgIndexX = 2;
			if (--delay == 0) {
				imgIndexY++;
				imgIndexY %= 3;
				delay = 10;
			}
			x += speed;
		}
		if (direction == WEST) {
			imgIndexX = 1;
			if (--delay == 0) {
				imgIndexY++;
				imgIndexY %= 3;
				delay = 10;
			}
			x -= speed;
		}
		if (direction == SOUTH) {
			imgIndexX = 0;
			if (--delay == 0) {
				imgIndexY++;
				imgIndexY %= 3;
				delay = 10;
			}
			y += speed;
		}

		int offsetX = 60 / 2;
		int offsetY = 60 / 2;
		int dx1 = (int) x - offsetX;
		int dy1 = (int) y - offsetY;
		int dx2 = (int) x + offsetX;
		int dy2 = (int) y + offsetY;
		g.drawImage(player, dx1, dy1, dx2, dy2, width * imgIndexX, height * imgIndexY, width * (imgIndexX + 1),
				height * (imgIndexY + 1), GameCanvas.getInstance());
	}

	public void move(int direction) {

		this.direction = direction;

	}

	public void lockup() {
		if (y > GameCanvas.getInstance().getHeight() - height)
			y = height;
		if (x > GameCanvas.getInstance().getWidth() - width)
			x = width;
		if (y < height)
			y = GameCanvas.getInstance().getHeight() - height;
		if (x < width)
			x = GameCanvas.getInstance().getWidth() - width;
	}

	public void setImgIndexY(int imgIndexY) {
		this.imgIndexY = imgIndexY;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}

}