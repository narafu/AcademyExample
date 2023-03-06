package project_01.smaple_0323;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Game extends Window {
	int x = 0;
	int y = 0;
	int[][] map = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 2, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };

	public Game() {
		super("Tile based Game Sample", 500, 500);
	}

	protected void draw(Graphics graphics) {
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map.length; y++) {
				switch (map[x][y]) {
				case 0:
					graphics.setColor(Color.darkGray);
					graphics.drawRect(x * 20, y * 20, 20, 20);
					break;
				case 1:
					graphics.setColor(Color.gray);
					graphics.fillRect(x * 20, y * 20, 20, 20);
					break;
				case 2:
					graphics.setColor(Color.green);
					graphics.fillRect(x * 20, y * 20, 20, 20);
					break;
				case 3:
					graphics.setColor(Color.red);
					graphics.fillRect(x * 20, y * 20, 20, 20);
					break;
				}
			}
		}
		graphics.setColor(Color.white);
		graphics.fillOval(x, y, 20, 20);
	}

	protected void typed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_LEFT:
			x -= 20;
			break;
		case KeyEvent.VK_UP:
			y -= 20;
			break;
		case KeyEvent.VK_RIGHT:
			x += 20;
			break;
		case KeyEvent.VK_DOWN:
			y += 20;
			break;
		case KeyEvent.VK_SPACE:
			map[x / 20][y / 20] = 3;
			break;
		}
	}
}