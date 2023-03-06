package ex03_ShootingGame.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import ex03_ShootingGame.item.Movable;
import ex03_ShootingGame.item.StartButton;

public class IntroCanvas extends Canvas {

	private static IntroCanvas introCanvas;
	private StartButton startButton;
	private Movable[] items;
	private int unitIndex;

	public IntroCanvas() {
		introCanvas = this;
		startButton = new StartButton();
		items = new Movable[100];
		items[unitIndex++] = startButton;

		this.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				if (startButton.contains(e.getX(), e.getY()))
					startButton.state(startButton.STATE_ON);
				else
					startButton.state(startButton.STATE_OFF);
			}
		});

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (startButton.contains(e.getX(), e.getY()))
					startButton.state(startButton.STATE_CLICK);
				ShootingFrame.getInstance().changeCanvas(2);
			}
		});
	}

	public void start() {

		Thread gameThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					dateUp();
					repaint();
					try {
						Thread.sleep(17); // 1√  = 1000
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public static IntroCanvas getInstance() {
		return introCanvas;

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

		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++)
			items[i].draw(gg);

		g.drawImage(buf, 0, 0, this);

	}
}
