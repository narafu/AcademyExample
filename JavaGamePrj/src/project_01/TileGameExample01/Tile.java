package project_01.TileGameExample01;

import java.awt.Graphics;
import java.awt.Color;

public class Tile {
	public enum Type {
		ROAD, WALL
	}

	private final int width = 20;
	private final int height = 20;
	private final Type type;
	private final int x;
	private final int y;

	public Tile(Type type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	public boolean isRoad() {
		return type == Type.ROAD;
	}

	public void draw(Graphics graphics) {
		switch (type) {
		case ROAD:
			graphics.setColor(Color.darkGray);
			graphics.drawRect(x * width, y * height, width, height);
			break;
		case WALL:
			graphics.setColor(Color.gray);
			graphics.fillRect(x * width, y * height, width, height);
			break;
		}
	}
}