package project_01.TileGameExample02;

import java.awt.Graphics;
import java.awt.Color;

public class Player {
	private final int radius = 10;
	private final int speed = 3;
	private int x = 0;
	private int y = 0;

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
		Map.isHit(this);
	}

	public void draw(Graphics graphics) {
		int drawX = x - radius;
		int drawY = y - radius;
		int drawSize = radius * 2;
		graphics.setColor(Color.green);
		graphics.fillOval(drawX, drawY, drawSize, drawSize);
		graphics.setColor(Color.black);
		graphics.drawOval(drawX, drawY, drawSize, drawSize);
	}
}