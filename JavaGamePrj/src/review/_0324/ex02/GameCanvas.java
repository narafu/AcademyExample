package review._0324.ex02;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameCanvas extends Canvas {

	private static GameCanvas gameCanvas;
	private final int NORTH = 1;
	private final int EAST = 2;
	private final int SOUTH = 4;
	private final int WEST = 8;
	private Movable[] items;
	private Fighter fighter;
	private Enemy enemy;
	private Space space;
	private int unitIndex, direction, countDown;
	private Random rand = new Random();

	public GameCanvas() {

		gameCanvas = this;
		space = new Space();
		fighter = new Fighter();
		enemy = new Enemy();

		countDown = rand.nextInt(120) + 60;
		items = new Movable[10];
		items[unitIndex++] = space;
		items[unitIndex++] = fighter;
		items[unitIndex++] = enemy;

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction |= WEST;
					break;
				case KeyEvent.VK_RIGHT:
					direction |= EAST;
					break;
				case KeyEvent.VK_UP:
					direction |= NORTH;
					break;
				case KeyEvent.VK_DOWN:
					direction |= SOUTH;
					break;
				}
				fighter.move(direction);

			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction ^= WEST;
					break;
				case KeyEvent.VK_RIGHT:
					direction ^= EAST;
					break;
				case KeyEvent.VK_UP:
					direction ^= NORTH;
					break;
				case KeyEvent.VK_DOWN:
					direction ^= SOUTH;
					break;
				}
				fighter.move(direction);
			}

		});

	}

	public static GameCanvas getInstance() {
		return gameCanvas;

	}

	public void start() {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					dateUp();
					repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void dateUp() {

		for (int i = 0; i < unitIndex; i++)
			items[i].dateUp();

		if (--countDown == 0) {
			if (unitIndex == items.length) {
				Movable[] temp = new Movable[items.length + 10];
				for (int i = 0; i < items.length; i++)
					temp[i] = items[i];
				items = temp;
			}
			enemy = new Enemy();
			items[unitIndex++] = enemy;
			countDown = rand.nextInt(120) + 60;
		}

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
			items[i].paint(gg);

		g.drawImage(buf, 0, 0, this);

	}

}
