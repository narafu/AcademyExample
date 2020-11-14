package project_01.TileGameExample01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Game extends Window {
	private Map map;
	private Player player = new Player(0, 0);

	public Game() {
		super("TITLE", Unit.WINDOW_WIDTH, Unit.WINDOW_HEIGHT);
		map = new Map(Unit.MAP_WIDTH, Unit.MAP_HEIGHT);
	}

	public void draw(Graphics graphics) {
		int x = 0;
		int y = 0;
		if (isKeyPressed(KeyEvent.VK_UP))
			y += 2;
		if (isKeyPressed(KeyEvent.VK_DOWN))
			y -= 2;
		if (isKeyPressed(KeyEvent.VK_LEFT))
			x -= 2;
		if (isKeyPressed(KeyEvent.VK_RIGHT))
			x += 2;
		player.move(x, y);
		player.setColor(Color.red);
		if (map.isWalkable(player.getX(), player.getY()))
			player.setColor(Color.green);
		map.draw(graphics);
		player.draw(graphics);
	}

	public void clicked(int x, int y) {
		System.out.printf("Mouse left-button clicked: %d %d\n", x, y);
	}
}