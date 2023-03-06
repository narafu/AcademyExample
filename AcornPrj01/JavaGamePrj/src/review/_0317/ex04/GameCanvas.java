package review._0317.ex04;

import java.awt.Canvas;
import java.awt.Graphics;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;

	private Puzzle[] puzzles;

	public GameCanvas() {
		canvas = this;
		puzzles = new Puzzle[6];
		puzzles[0] = new Puzzle(1);

	}

	public static GameCanvas getInstance() {
		return canvas;
	}

	@Override
	public void paint(Graphics g) {

		Puzzle puzzle = puzzles[0];
		puzzle.draw(g);
	}

}
