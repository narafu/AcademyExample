package project_01.TileGameExample00;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

public class Player {
	private final int radius = 40;
	private final int speed = 3;
	private int x = 0;
	private int y = 0;
	private static Image man;
	static {
		try {
			man = ImageIO.read(new File("res/image/man.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Player(int tileX, int tileY) {
		this.x = tileX * Unit.tileSize + Unit.tileHalfSize;
		this.y = tileY * Unit.tileSize + Unit.tileHalfSize;
	}

	public int x() {
		return x;
	}

	public void x(int x) {
		this.x = x;
	}

	public int y() {
		return y;
	}

	public void y(int y) {
		this.y = y;
	}

	public int size() {
		return radius;
	}

	public int speed() {
		return speed;
	}

	public void move(int offsetX, int offsetY) {
		x += offsetX * speed;
		y += offsetY * speed;
		if (x < 0)
			x = Unit.windowWidth;
		if (Unit.windowWidth < x)
			x = 0;
		if (y < 0)
			y = Unit.windowHeight;
		if (Unit.windowHeight < y)
			y = 0;
		Map.isHit(this);
	}

	public void draw(Graphics g, int indexX, int indexY) {
		int drawX = x - radius;
		int drawY = y - radius;
		int drawSize = radius * 2;
		g.drawImage(man, drawX, drawY, drawX + drawSize, drawY + drawSize, 20 * indexX, 30 * indexY, 20 * (indexX + 1),
				30 * (indexY + 1), null);
	}
}