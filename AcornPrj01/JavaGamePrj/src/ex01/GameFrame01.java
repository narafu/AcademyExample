package ex01;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameFrame01 extends Frame {

	private Image img;

	public GameFrame01() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/image/img0316.png");
	}

	@Override
	public void paint(Graphics g) {

		int w = 1920;
		int h = 1357;
		// 1
		g.drawImage(img, 25, 50, w / 4 + 50, h / 4 + 50, w / 2, 0, w, h / 2, this);
		// 2
		g.drawImage(img, 25, h / 4 + 75, w / 4 + 50, h / 2 + 75, 0, 0, w / 2, h / 2, this);
		// 3
		g.drawImage(img, w / 4 + 75, h / 4 + 75, w / 2 + 75, h / 2 + 75, 0, h / 2, w / 2, h, this);
		// 4
		g.drawImage(img, w / 4 + 75, 50, w / 2 + 75, h / 4 + 50, w / 2, h / 2, w, h, this);

	}

}
