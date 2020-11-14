package review._0318.ex06;

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
		space = new Space();
		fighter = new Fighter();

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
		GameThread.start();
	}

	public void update() {
		space.update();
		fighter.update();

	}
	@Override
	public void paint(Graphics g) {
		space.draw(g);
		fighter.draw(g);
	}

}
