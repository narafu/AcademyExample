package ex02_Puzzle_Game;

import java.awt.Frame;

public class GameFrame extends Frame {

	private PuzzleCanvas canvas;

	public GameFrame() {

		canvas = new PuzzleCanvas(); // 캔버스 생성
		this.add(canvas); // 프레임에 캔버스 붙이는 작업

	}

}
