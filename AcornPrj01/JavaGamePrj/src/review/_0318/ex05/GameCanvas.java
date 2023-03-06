package review._0318.ex05;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	private Fighter fighter;
	private Enemy enemy;
	private Space space;

	public GameCanvas() {

		canvas = this;
		fighter = new Fighter();
		enemy = new Enemy();
		space = new Space();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				fighter.move(e.getX(), e.getY());
			}
		});
	}

	public static GameCanvas getInstance() {
		return canvas;
	}

	public void start() {

		Thread GameThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					GameCanvas.this.update();
					GameCanvas.this.repaint();
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		GameThread.start();

	}

	protected void update() {
		fighter.update();
		enemy.update();
		space.update();
	}

	@Override
	public void paint(Graphics g) {
		fighter.draw(g);
		enemy.draw(g);
		space.draw(g);
	}
}
