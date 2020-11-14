package project_01.TileGameExample02;

import java.awt.Graphics;
import java.awt.Color;

public class Tile {
	public enum Type {
		ROAD, WALL,
	}

	private final Type type;
	private final int tileX;
	private final int tileY;

	public Tile(Type type, int tileX, int tileY) {
		this.type = type;
		this.tileX = tileX;
		this.tileY = tileY;
	}

	public boolean isRoad() {
		return type == Type.ROAD;
	}

	private boolean isEdgeHit(int x1, int y1, int x2, int y2, int r) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < r * r;
	}

	private int getEdgeDistance(int x1, int y1, int x2, int y2, int r) {
		return (int) (r - Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
	}

	private boolean getAsix(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) > (y1 - y2) * (y1 - y2);
	}

	public void isHit(Player player) {
		if (type != Type.WALL)
			return;
		int left = tileX * Unit.tileSize;
		int top = tileY * Unit.tileSize;
		int right = left + Unit.tileSize;
		int bottom = top + Unit.tileSize;
		int x = player.x();
		int y = player.y();
		int r = player.size();
		if (left - r > x || top - r > y || right + r < x || bottom + r < y) {
			return;
		}
		if (left > x && top <= y && bottom >= y) {
			player.x(left - r);
			return;
		}
		if (top > y && left <= x && right >= x) {
			player.y(top - r);
			return;
		}
		if (right < x && top <= y && bottom >= y) {
			player.x(right + r);
			return;
		}
		if (bottom < y && left <= x && right >= x) {
			player.y(bottom + r);
			return;
		}
		if (left > x && top > y && isEdgeHit(left, top, x, y, r)) {
			int distance = getEdgeDistance(left, top, x, y, r);
			if (getAsix(left, top, x, y))
				player.x(player.x() - distance);
			else
				player.y(player.y() - distance);
			return;
		}
		if (left > x && bottom < y && isEdgeHit(left, bottom, x, y, r)) {
			int distance = getEdgeDistance(left, bottom, x, y, r);
			if (getAsix(left, bottom, x, y))
				player.x(player.x() - distance);
			else
				player.y(player.y() + distance);
			return;
		}
		if (right < x && top > y && isEdgeHit(right, top, x, y, r)) {
			int distance = getEdgeDistance(right, top, x, y, r);
			if (getAsix(right, top, x, y))
				player.x(player.x() + distance);
			else
				player.y(player.y() - distance);
			return;
		}
		if (right < x && bottom < y && isEdgeHit(right, bottom, x, y, r)) {
			int distance = getEdgeDistance(right, bottom, x, y, r);
			if (getAsix(right, bottom, x, y))
				player.x(player.x() + distance);
			else
				player.y(player.y() + distance);
			return;
		}
	}

	public void draw(Graphics graphics) {
		int drawX = tileX * Unit.tileSize;
		int drawY = tileY * Unit.tileSize;
		switch (type) {
		case ROAD:
			graphics.setColor(Color.darkGray);
			graphics.drawRect(drawX, drawY, Unit.tileSize, Unit.tileSize);
			break;
		case WALL:
			graphics.setColor(Color.gray);
			graphics.fillRect(drawX, drawY, Unit.tileSize, Unit.tileSize);
			break;
		}
	}
}