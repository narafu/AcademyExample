package review._0317.ex01;

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

		g.drawImage(img, 0, 0, width / 2, height / 2, 0, 0, width / 2, height / 2, this);

	}

}
