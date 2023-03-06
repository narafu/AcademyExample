package ex02_Puzzle_Game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Puzzle {

	private Image img;
	private int width, height;
	private int sx, sy;
	private int index;

	public Puzzle(int index) {
		this.index = index;
		// Toolkit tk = Toolkit.getDefaultToolkit();
		// img = tk.getImage("res/image/dragon.jpg");

		// 1. 이미지가 로드될 때까지 기다려 주도록 하는 방법 - MediaTracker
		// 2. img = ImageIO.read(new File("res/image/dragon.jpg")); + 예외처리

		try {
			img = ImageIO.read(new File("res/image/dragon.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		width = img.getWidth(PuzzleCanvas.getInstance()) / 3;
		height = img.getHeight(PuzzleCanvas.getInstance()) / 2;
	}

	public void draw(Graphics g) {

		// 위 - 왼
		g.drawImage(img, 0, 0, width, height, 0, 0, width, height, PuzzleCanvas.getInstance());
		// 위 - 중
		g.drawImage(img, width, 0, width * 2, height, width, 0, width * 2, height, PuzzleCanvas.getInstance());
		// 위 - 오
		g.drawImage(img, width * 2, 0, width * 3, height, width * 2, 0, width * 3, height, PuzzleCanvas.getInstance());
		// 아래 - 왼
		g.drawImage(img, 0, height, width, height * 2, 0, height, width, height * 2, PuzzleCanvas.getInstance());
		// 아래 - 중
		g.drawImage(img, width, height, width * 2, height * 2, width, height, width * 2, height * 2,
				PuzzleCanvas.getInstance());
		// 아 - 오
		g.drawImage(img, width * 2, height, width * 3, height * 2, width * 2, height, width * 3, height * 2,
				PuzzleCanvas.getInstance());

	}

}
