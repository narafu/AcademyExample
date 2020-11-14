package review._0321;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas03 extends Canvas {

	private static GameCanvas03 canvas;
	private Fighter fighter;
	private Space space;
	private Movable[] items;
	private int index = 0;

	public GameCanvas03() {

		canvas = this;
		fighter = new Fighter();
		space = new Space();
		items = new Movable[100];

		items[index++] = space;
		items[index++] = fighter;

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				fighter.move(e.getX(), e.getY());
				repaint();
			}

		});

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
				case KeyEvent.VK_SPACE:
					fighter.fire();
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				fighter.setImgIndex(3);
			}

		});
	}

	public static GameCanvas03 getInstance() {
		return canvas;
	}

	public void start() {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					dateUp();
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();

	}

	protected void dateUp() {

		for (int i = 0; i < index; i++)
			items[i].dateUp();

	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < index; i++)
			iteam[i].paint(gg);

		g.drawImage(buf, 0, 0, this);

	}

	@Override
	public void update(Graphics g) {

		paint(g);

	}

}
