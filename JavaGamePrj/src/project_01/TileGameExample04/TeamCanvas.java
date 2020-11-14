package project_01.TileGameExample04;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class TeamCanvas extends Canvas {

	private Player1 fighter;
	private Map space;
	private static TeamCanvas canvas;

	public TeamCanvas() {
		canvas = this;
	}

	// �̱���
	public static TeamCanvas getInstance() {
		return canvas;
	}

	public void update() {
//		for (int i = 0; i < unitIndex; i++)
//			items[i].update();
	}

	public void start() {
		Thread gameThread = new Thread(new Runnable() {
			@Override
			public void run() { // ���ο� �帧�� ���� �Լ�
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(16);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	@Override
	public void update(Graphics g) {
		this.paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();
		// ��� ������ �̹��� ���ۿ� �׸��� �׸����ϰ�
//		for (int i = 0; i < unitIndex; i++)
//			items[i].draw(gg);
		// ��� �׸� �� �ѹ��� �׷����� ?
//		g.drawImage(buf, 0, 0, this);
	}

}
