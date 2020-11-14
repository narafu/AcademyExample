package review._0323.ex02;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class IntroCanvas extends Canvas {

	private static IntroCanvas introCanvas;
	private StartButton startButton = new StartButton();

	public IntroCanvas() {

		introCanvas = this;

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				if (startButton.contains(e.getX(), e.getY())) {
					startButton.state(startButton.STATE_CLICK);
					GameFrame.getInstance().changeCanvas();
				}
			}

		});

		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {

				if (startButton.contains(e.getX(), e.getY()))
					startButton.state(startButton.STATE_ON);
				else
					startButton.state(startButton.STATE_OFF);
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

	protected void dateUp() {

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics gg = buf.getGraphics();

		startButton.draw(gg);

		g.drawImage(buf, 0, 0, this);

	}

	public static IntroCanvas getInstance() {
		return introCanvas;
	}

}
