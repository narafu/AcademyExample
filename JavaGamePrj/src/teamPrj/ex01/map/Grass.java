package teamPrj.ex01.map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import teamPrj.ex01.Code;
import teamPrj.ex01.GameCanvas;
import teamPrj.ex01.Map;

public class Grass implements Map {

	private static Image img;
	private int numX, numY, width, height;

	static {
		try {
			img = ImageIO.read(new File("res/image/grass.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Grass() {
		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());
		numX = Code.TILE_NUM_X;
		numY = Code.TILE_NUM_Y;

	}

	public void draw(Graphics g) {

		for (int i = 0; i < numX; i++) {
			for (int j = 0; j < numY; j++) {
				g.drawImage(img, Code.TILE_SIZE * i, Code.TILE_SIZE * j, Code.TILE_SIZE * (i + 1),
						Code.TILE_SIZE * (j + 1), 0, 0, width, height, GameCanvas.getInstance());
				g.drawRect(i * Code.TILE_SIZE, j * Code.TILE_SIZE, Code.TILE_SIZE, Code.TILE_SIZE);
			}
		}

	}
}
