package review._0317.ex10;

import java.awt.Frame;

public class GameFrame extends Frame {

	private GameCanvas canvas;

	public GameFrame() {
		canvas = new GameCanvas();
		this.add(canvas);

	}

}
