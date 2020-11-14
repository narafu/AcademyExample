package review._0317.ex07;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends Canvas {

	private Fighter fighter;
	private static GameCanvas canvas;

	public GameCanvas() {
		canvas = this;
		fighter = new Fighter();
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				fighter.move(e.getX(), e.getY());
				GameCanvas.this.repaint();

			}

		});

	}

	public static GameCanvas getInstance() {
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

	}

	private void update() {

		fighter.update();

	}

}
