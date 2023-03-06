package review._0318.ex01;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	private Fighter fighter;

	public GameCanvas() {
		canvas = this;
		fighter = new Fighter();

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				fighter.move(e.getX(), e.getY());

			}

		});

	}

	static GameCanvas getInstance() {
		return canvas;
	}

	@Override
	public void paint(Graphics g) {
		fighter.draw(g);
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();

	}

	private void update() {
		fighter.update();

	}

}
