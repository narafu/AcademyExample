package ex02_Puzzle_Game;

import java.awt.Frame;

public class GameFrame extends Frame {

	private PuzzleCanvas canvas;

	public GameFrame() {

		canvas = new PuzzleCanvas(); // ĵ���� ����
		this.add(canvas); // �����ӿ� ĵ���� ���̴� �۾�

	}

}
