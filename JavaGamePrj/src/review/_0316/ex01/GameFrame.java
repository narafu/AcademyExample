package review._0316.ex01;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameFrame extends Frame {

	private Image img;

	public GameFrame() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/image/dragon.jpg");
	}

	@Override
	public void paint(Graphics g) {

		int width = 1280;
		int height = 720;

		// ¿Þ-À§
		g.drawImage(img, 25, 50, width / 4 + 25, height / 4 + 50, width / 2, 0, width, height / 2, this);
		// ¿Þ-¾Æ·¡
		g.drawImage(img, 25, height / 4 + 75, width / 4 + 25, height / 2 + 75, 0, 0, width / 2, height / 2, this);
		// ¿À-¾Æ·¡
		g.drawImage(img, width / 4 + 50, height / 4 + 75, width / 2 + 50, height / 2 + 75, 0, height / 2, width / 2,
				height, this);
		// ¿À-À§
		g.drawImage(img, width / 4 + 50, 50, width / 2 + 50, height / 4 + 50, width / 2, height / 2, width, height,
				this);

	}
}
