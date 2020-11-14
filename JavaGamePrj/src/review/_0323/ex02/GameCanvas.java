package review._0323.ex02;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends Canvas {

	private static GameCanvas gameCanvas;
	private Space space;
	private Fighter fighter;
	private Movable[] items;
	private int unitIndex = 0;

	public GameCanvas() {
		gameCanvas = this;
		space = new Space();
		fighter = new Fighter();
		items = new Movable[100];
		items[unitIndex++] = space;
		items[unitIndex++] = fighter;

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					fighter.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					fighter.moveRight();
					break;
				case KeyEvent.VK_UP:
					fighter.moveUp();
					break;
				case KeyEvent.VK_DOWN:
					fighter.moveDown();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				fighter.setImageIndex(3);
			}
		});
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
