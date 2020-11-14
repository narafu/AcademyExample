package review._0318.ex03;

import java.awt.Canvas;
import java.awt.Graphics;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	private Fighter fighter = new Fighter();

	public GameCanvas() {
		canvas = this;
	}

	static GameCanvas getInstance() {
		return canvas;
	}

	@Override
	public void paint(Graphics g) {
		fighter.draw(g);
	}

}
