package project_01.TileGameExample01;

import java.awt.Graphics;
import java.util.Random;

public class Map {
	private Tile[][] map;

	public Map(int width, int height) {
		Random random = new Random();
		this.map = new Tile[width][height];
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				Tile.Type type = Tile.Type.ROAD;
				if (random.nextInt(10) < 3)
					type = Tile.Type.WALL;
				map[x][y] = new Tile(type, x, y);
			}
		}
	}

	public void draw(Graphics graphics) {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y].draw(graphics);
			}
		}
	}

	public boolean isWalkable(int x, int y) {
		int tileX = x / Unit.TILE_WIDTH;
		int tileY = y / Unit.TILE_HEIGHT;
		return map[tileX][tileY].isRoad();
	}
}