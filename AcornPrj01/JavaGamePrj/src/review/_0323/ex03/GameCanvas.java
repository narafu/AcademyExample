package review._0323.ex03;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class GameCanvas extends Canvas {

	private static GameCanvas gameCanvas;
	private Space space;

	public GameCanvas() {
		gameCanvas = this;
		space = new Space();

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
		space.dateUp();
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics gg = buf.getGraphics();

		space.paint(gg);

		g.drawImage(buf, 0, 0, this);
	}

	public static GameCanvas getInstance() {
		return gameCanvas;
	}

}
