package project_01.TileGameExample00;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class Game extends Window {
	private Player player;
	private LinkedList<Bomb> bombs = new LinkedList<>();
	private static Game canvas;

	public Game() {

		super("Solo Project", Unit.windowWidth, Unit.windowHeight);

		Map.initialize(Unit.mapWidth, Unit.mapHeight);

		for (int i = 0; i < Unit.mapWidth * Unit.mapHeight; i++) {
			int tileX = i / Unit.mapWidth;
			int tileY = i % Unit.mapHeight;
			if (Map.isWalkable(tileX, tileY)) {
				player = new Player(tileX, tileY);
				break;
			}
		}
	}

	protected void draw(Graphics graphics) {

		Map.draw(graphics);
		drawBombs(graphics);
		drawPlayer(graphics);
		graphics.setColor(Color.WHITE);
		graphics.drawString(String.format("Player-X: %d", player.x()), 1, 60);
		graphics.drawString(String.format("Player-Y: %d", player.y()), 1, 75);

	}

	private void drawPlayer(Graphics graphics) {
		int x = 0;
		int y = 0;
		int indexX = 0;
		int indexY = 0;
		int tileHalfX = player.x() / Unit.tileHalfSize;
		int tileHalfY = player.y() / Unit.tileHalfSize;
		if (isKeyPressed(KeyEvent.VK_UP)) {
			y -= 1;
			indexX = 3;
			if (tileHalfY % 2 == 0)
				indexY = 1;
			else
				indexY = 2;
		}
		if (isKeyPressed(KeyEvent.VK_DOWN)) {
			y += 1;
			if (tileHalfY % 2 == 0)
				indexY = 1;
			else
				indexY = 2;
		}
		if (isKeyPressed(KeyEvent.VK_LEFT)) {
			x -= 1;
			indexX = 1;
			if (tileHalfX % 2 == 0)
				indexY = 1;
			else
				indexY = 2;
		}
		if (isKeyPressed(KeyEvent.VK_RIGHT)) {
			x += 1;
			indexX = 2;
			if (tileHalfX % 2 == 0)
				indexY = 1;
			else
				indexY = 2;

		}
		if (x != 0 || y != 0)
			player.move(x, y);
		player.draw(graphics, indexX, indexY);
	}

	private void drawBombs(Graphics graphics) {
		boolean isInstallBomb = isKeyPressed(KeyEvent.VK_SPACE);
		int tileX = player.x() / Unit.tileSize;
		int tileY = player.y() / Unit.tileSize;
		for (int i = 0; isInstallBomb && i < bombs.size(); i++) {
			if (bombs.get(i).isXY(tileX, tileY)) {
				isInstallBomb = false;
				break;
			}
		}

		if (2 < bombs.size())
			isInstallBomb = false;

		if (isInstallBomb && Map.isWalkable(tileX, tileY)) {
//      Random random = new Random();
//      int flameSize = random.nextInt(7) + 1;
			int flameSize = 2;
			bombs.add(new Bomb(tileX, tileY, flameSize));
		}
		for (Iterator<Bomb> i = bombs.iterator(); i.hasNext();) {
			if (i.next().isDone())
				i.remove();
		}
		for (Bomb bomb : bombs)
			bomb.draw(graphics);
	}

}