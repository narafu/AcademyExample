package ex02_Puzzle_Game;

import java.awt.Canvas;
import java.awt.Graphics;

public class PuzzleCanvas extends Canvas {

	private static PuzzleCanvas canvas;

	private Puzzle[] puzzles;

	public PuzzleCanvas() {
		canvas = this;
		puzzles = new Puzzle[6];
		puzzles[0] = new Puzzle(0);
		puzzles[0].move(); 

	}

	public static PuzzleCanvas getInstance() {
		return canvas;
	}

	@Override
	public void paint(Graphics g) {

		Puzzle puzzle = puzzles[0];
		puzzle.draw(g);

//		g.drawLine(0, 0, 100, 100);
//		g.setColor(Color.blue);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
//		observer는 그림판

	}

}
