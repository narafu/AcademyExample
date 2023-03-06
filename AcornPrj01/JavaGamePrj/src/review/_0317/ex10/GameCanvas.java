package review._0317.ex10;

import java.awt.Canvas;
import java.awt.Graphics;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	private Dragon1 dragon1;
	private Dragon2 dragon2;
	private Dragon3 dragon3;
	private Dragon4 dragon4;
	private Dragon5 dragon5;
	private Dragon6 dragon6;

	public GameCanvas() {

		canvas = this;
		dragon1 = new Dragon1();
		dragon2 = new Dragon2();
		dragon3 = new Dragon3();
		dragon4 = new Dragon4();
		dragon5 = new Dragon5();
		dragon6 = new Dragon6();

	}

	public static GameCanvas getInstance() {
		return canvas;
	}

	@Override
	public void paint(Graphics g) {

		dragon1.draw(g);
		dragon2.draw(g);
		dragon3.draw(g);
		dragon4.draw(g);
		dragon5.draw(g);
		dragon6.draw(g);

	}

}
