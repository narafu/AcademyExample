package ex01;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameFrame00 extends Frame {

	private Image imgFighter;

	public GameFrame00() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		imgFighter = tk.getImage("res/image/fighter.png");
	}

	@Override
	public void paint(Graphics g) {

		g.drawLine(0, 0, 300, 300);
		int w = 64;
		int h = 64;
		int offsetX = w * (4 - 1);
		g.drawImage(imgFighter, 100, 100, 100 + w, 100 + h, offsetX, 0, offsetX + w, h, this);
	}

}
