package project_01.TileGameExample02;

import java.awt.Graphics;
import java.util.Random;

public class Map {
	private static Tile[][] map;

	public static void initialize(int width, int height) {
		Random random = new Random();
		map = new Tile[width][height];
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				Tile.Type type = Tile.Type.ROAD;
				if (random.nextInt(10) < 1)
					type = Tile.Type.WALL;
				map[x][y] = new Tile(type, x, y);
			}
		}
	}

	private static void isTileHit(int tileX, int tileY, Player player) {
		if (tileX < 0 || tileX >= map.length)
			return;
		if (tileY < 0 || tileY >= map[0].length)
			return;
		map[tileX][tileY].isHit(player);
	}

	public static void isHit(Player player) {
		int tileX = player.x() / Unit.tileSize;
		int tileY = player.y() / Unit.tileSize;
		Map.isTileHit(tileX, tileY - 1, player);
		Map.isTileHit(tileX, tileY + 1, player);
		Map.isTileHit(tileX - 1, tileY, player);
		Map.isTileHit(tileX + 1, tileY, player);
		Map.isTileHit(tileX - 1, tileY - 1, player);
		Map.isTileHit(tileX + 1, tileY - 1, player);
		Map.isTileHit(tileX - 1, tileY + 1, player);
		Map.isTileHit(tileX + 1, tileY + 1, player);
	}

	public static void draw(Graphics graphics) {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				map[x][y].draw(graphics);
			}
		}
	}

	public static boolean isWalkable(int tileX, int tileY) {
		if (tileX < 0 || tileX >= map.length)
			return false;
		if (tileY < 0 || tileY >= map[0].length)
			return false;
		return map[tileX][tileY].isRoad();
	}
}