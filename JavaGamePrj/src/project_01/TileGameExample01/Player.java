package project_01.TileGameExample01;

import java.awt.Graphics;
import java.awt.Color;

public class Player {
	final int size = 9;
	int x = 0;
	int y = 0;
	Color color;

	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		color = Color.green;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void move(int x, int y) {
		this.x += x;
		this.y -= y;
	}

	public void draw(Graphics graphics) {
		int drawX = x - size / 2;
		int drawY = y - size / 2;
		graphics.setColor(color);
		graphics.fillOval(drawX, drawY, size, size);
		graphics.setColor(Color.black);
		graphics.drawOval(drawX, drawY, size, size);
	}
}