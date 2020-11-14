package teamPrj.ex01.map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import teamPrj.ex01.Code;
import teamPrj.ex01.GameCanvas;
import teamPrj.ex01.Map;

public class Stone implements Map {

	private static Image img;
	private int numX, numY, width, height;
	private int[] sx, sy;
	private int[][] stone;

	static {
		try {
			img = ImageIO.read(new File("res/image/stone.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Stone() {
		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());
		numX = Code.STONE_NUM_X;
		numY = Code.STONE_NUM_Y;

		sx = new int[numX];
		sy = new int[numY];
		stone = new int[Code.TILE_NUM_X][Code.TILE_NUM_Y];

		Random rand = new Random();
		for (int i = 0; i < numX; i++) {
			for (int j = 0; j < numY; j++) {
				sx[i] = rand.nextInt(Code.TILE_NUM_X);
				sy[j] = rand.nextInt(Code.TILE_NUM_Y);
				stone[sx[i]][sy[j]] = Code.STONE;
			}

		}

	}

	public void draw(Graphics g) {

		for (int i = 0; i < numX; i++) {
			for (int j = 0; j < numY; j++) {
				if (stone[sx[i]][sy[j]] == Code.STONE)
					g.drawImage(img, Code.TILE_SIZE * sx[i], Code.TILE_SIZE * sy[j], Code.TILE_SIZE * (sx[i] + 1),
							Code.TILE_SIZE * (sy[j] + 1), 0, 0, width, height, GameCanvas.getInstance());
			}
		}
	}

}
