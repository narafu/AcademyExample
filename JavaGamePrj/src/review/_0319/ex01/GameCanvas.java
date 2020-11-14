package review._0319.ex01;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	private Fighter fighter;
	private Space space;

	public GameCanvas() {
		canvas = this;
		fighter = new Fighter();
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

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					GameCanvas.this.update();
					GameCanvas.this.repaint();
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

	public void update() {
		fighter.update();
		space.update();
	}

	@Override
	public void paint(Graphics g) {
		space.draw(g);
		fighter.draw(g);
	}

}
