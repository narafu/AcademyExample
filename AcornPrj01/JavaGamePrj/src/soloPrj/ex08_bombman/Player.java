package soloPrj.ex08_bombman;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Player implements Unit {

	private static Image img;
	private int width, height, imgIndexX, imgIndexY;
	private int speed, direction;
	private double x, y;

	static {
		try {
			img = ImageIO.read(new File("res/image/player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "image error");
		}
	}

	public Player() {

		width = img.getWidth(GameCanvas.getInstance()) / 4;
		height = img.getHeight(GameCanvas.getInstance()) / 3;
		speed = 5;
	}

	public void move(int direction) {
		this.direction = direction;

	}

	public void bomb() {

	}

	public void draw(Graphics g) {
		int north = GameCanvas.getInstance().NORTH;
		int east = GameCanvas.getInstance().EAST;
		int south = GameCanvas.getInstance().SOUTH;
		int west = GameCanvas.getInstance().WEST;
		int tileSize = GameCanvas.getInstance().TILE_SIZE;

		if ((direction & north) == north) {
			imgIndexX = 3;
			imgIndexY++;
			imgIndexY %= 3;
			y -= speed;
		}
		if ((direction & east) == east) {
			imgIndexX = 2;
			imgIndexY++;
			imgIndexY %= 3;
			x += speed;
		}
		if ((direction & south) == south) {
			imgIndexX = 0;
			imgIndexY++;
			imgIndexY %= 3;
			y += speed;
		}
		if ((direction & west) == west) {
			imgIndexY++;
			imgIndexX = 1;
			imgIndexY %= 3;
			x -= speed;
		}

		g.drawImage(img, (int) x, (int) y, (int) x + tileSize, (int) y + tileSize, width * imgIndexX,
				height * imgIndexY, width * (imgIndexX + 1), height * (imgIndexY + 1), GameCanvas.getInstance());
	}

	public void setImgIndexX(int imgIndexX) {
		this.imgIndexX = imgIndexX;
	}

	public void setImgIndexY(int imgIndexY) {
		this.imgIndexY = imgIndexY;
	}

	@Override
	public void dateUp() {
		// TODO Auto-generated method stub

	}

}
