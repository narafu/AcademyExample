package teamPrj.ex00;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	private static final int NORTH = 1;
	private static final int EAST = 2;
	private static final int SOUTH = 4;
	private static final int WEST = 8;
	private Player player;
	private Map map;
	private Bomb bomb;
	private Effect effect;
	private Movable[] items;
	private int unitIndex, direction, delay;

	public GameCanvas() {
		canvas = this;
		map = new Map();
		player = new Player();
		bomb = new Bomb();
		delay = 4;
//		effect = new Effect();

		items = new Movable[100];
		items[unitIndex++] = map;
		items[unitIndex++] = player;
		items[unitIndex++] = bomb;
//		items[unitIndex++] = effect;

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
				case KeyEvent.VK_SPACE:
					bomb = new Bomb(player.getX(), player.getY());
					items[unitIndex++] = bomb;
					effect = new Effect(bomb.getX(), bomb.getY());
					items[unitIndex++] = effect;

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
				}
				player.move(direction);
			}
		});
	}

	public static GameCanvas getInstance() {
		return canvas;
	}

	public void update() {
		for (int i = 0; i < unitIndex; i++)
			items[i].update();

		// 가변배열
		if (unitIndex == items.length) {
			Movable[] temp = new Movable[items.length + 50];
			for (int i = 0; i < unitIndex; i++)
				temp[i] = items[i];
			items = temp;
		}

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

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(getWidth(), getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++)
			items[i].draw(gg);

		g.drawImage(buf, 0, 0, this);
	}
}