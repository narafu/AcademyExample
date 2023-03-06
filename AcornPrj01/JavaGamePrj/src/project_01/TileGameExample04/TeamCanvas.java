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

	// 싱글톤
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
			public void run() { // 새로운 흐름의 메인 함수
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
		// 모든 유닛은 이미지 버퍼에 그림을 그리게하고
//		for (int i = 0; i < unitIndex; i++)
//			items[i].draw(gg);
		// 모든 그림 이 한번에 그려지면 ?
//		g.drawImage(buf, 0, 0, this);
	}

}
