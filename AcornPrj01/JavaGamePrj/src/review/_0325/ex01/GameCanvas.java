package review._0325.ex01;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameCanvas extends Canvas {

	private static GameCanvas gameCanvas;
	private Movable[] items;
	private Fighter fighter;
	private Enemy enemy;
	private Space space;
	private int unitIndex;

	public GameCanvas() {

		gameCanvas = this;
		space = new Space();
		fighter = new Fighter();
		enemy = new Enemy();

		items = new Movable[10];
		items[unitIndex++] = space;
		items[unitIndex++] = fighter;
		items[unitIndex++] = enemy;

		addKeyListener(new KeyAdapter() {

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
