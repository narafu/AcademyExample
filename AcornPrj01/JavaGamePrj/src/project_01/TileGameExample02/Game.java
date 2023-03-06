package project_01.TileGameExample02;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.awt.Color;

public class Game extends Window {
	private Player player;
	private LinkedList<Bomb> bombs = new LinkedList<>();

	public Game() {
		super("Tile based Game Sample", Unit.windowWidth, Unit.windowHeight);
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
		if (isKeyPressed(KeyEvent.VK_UP))
			y -= 1;
		if (isKeyPressed(KeyEvent.VK_DOWN))
			y += 1;
		if (isKeyPressed(KeyEvent.VK_LEFT))
			x -= 1;
		if (isKeyPressed(KeyEvent.VK_RIGHT))
			x += 1;
		if (x != 0 || y != 0)
			player.move(x, y);
		player.draw(graphics);
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
		if (isInstallBomb && Map.isWalkable(tileX, tileY)) {
			Random random = new Random();
			int flameSize = random.nextInt(7) + 1;
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