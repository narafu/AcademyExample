package teamPrj.ex01;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import teamPrj.ex01.map.Box;
import teamPrj.ex01.map.Forest;
import teamPrj.ex01.map.Grass;
import teamPrj.ex01.map.Stone;

public class GameCanvas extends Canvas {

	private static final int NORTH = 1;
	private static final int EAST = 2;
	private static final int SOUTH = 4;
	private static final int WEST = 8;
	private static GameCanvas canvas;
	private Player player;
	private Enemy enemy;
	private Stone stone;
	private Grass grass;
	private Forest forest;
	private Box box;
	private Map[] map;
	private int direction, index;

	public GameCanvas() {
		canvas = this;
		player = new Player();
		grass = new Grass();
		stone = new Stone();
		enemy = new Enemy();
		forest = new Forest();
		box = new Box();

		map = new Map[100];
		map[index++] = grass;
		map[index++] = stone;

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction = WEST;
					break;
				case KeyEvent.VK_UP:
					direction = NORTH;
					break;
				case KeyEvent.VK_RIGHT:
					direction = EAST;
					break;
				case KeyEvent.VK_DOWN:
					direction = SOUTH;
					break;
				}
				player.move(direction);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction &= ~WEST;
					break;
				case KeyEvent.VK_UP:
					direction &= ~NORTH;
					break;
				case KeyEvent.VK_RIGHT:
					direction &= ~EAST;
					break;
				case KeyEvent.VK_DOWN:
					direction &= ~SOUTH;
					break;
				case KeyEvent.VK_SPACE:

					break;
				}
				player.move(direction);
				player.setImgIndexY(0);

			}
		});
	}

	public static GameCanvas getInstance() {
		return canvas;
	}

	public void start() {
		Thread gameThread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void update() {

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(getWidth(), getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < index; i++)
			map[i].draw(gg);

		g.drawImage(buf, 0, 0, this);
	}

}