package teamPrj.good;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class IntroCanvas extends Canvas {

	private static IntroCanvas introCanvas;
	private Cursor cursorHand, cursorDefault;
	private StartImage start;
	private BackGround back;
	private Hand hand;
	private File file;
	private AudioInputStream stream;
	private Movable[] items;
	private int unitIndex;

	public IntroCanvas() {
		introCanvas = this;
		items = new Movable[10];
		back = new BackGround();
		start = new StartImage();
		hand = new Hand();
		file = new File("res/sound/start.wav");
		items[unitIndex++] = back;
		items[unitIndex++] = start;
		items[unitIndex++] = hand;

		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {

				if ((550 < e.getX()) && (e.getX() < 720) && (500 < e.getY()) && (e.getY() < 700)) {
					cursorHand = new Cursor(Cursor.HAND_CURSOR);
					setCursor(cursorHand);
				} else {
					cursorHand = new Cursor(Cursor.DEFAULT_CURSOR);
					setCursor(cursorDefault);
				}
			}

		});

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if ((550 < e.getX()) && (e.getX() < 720) && (500 < e.getY()) && (e.getY() < 700)) {
					try {
						AudioInputStream stream = AudioSystem.getAudioInputStream(file);
						Clip clip = AudioSystem.getClip();
						clip.open(stream);
						clip.start();

					} catch (Exception w) {

						w.printStackTrace();
					}
					OmokFrame.getInstance().changeCanvas(2);
				}

			}

		});
	}

	public void start() {
		Thread th = new Thread(new Runnable() {

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
		th.start();

	}

	public void update() {
		for (int i = 0; i < unitIndex; i++)
			items[i].update();

	}

	public static IntroCanvas getInstance() {
		return introCanvas;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics bufG = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++)
			items[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);

	}

}