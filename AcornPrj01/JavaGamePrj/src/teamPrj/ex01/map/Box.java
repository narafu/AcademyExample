package teamPrj.ex01.map;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import teamPrj.ex01.Code;
import teamPrj.ex01.GameCanvas;

public class Box {

	private static Image img;
	private int NumX, NumY, width, height;

	static {
		try {
			img = ImageIO.read(new File("res/image/itembox.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Box() {
		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());
		NumX = Code.BoxNumX;
		NumY = Code.BoxNumY;
	}

	public void draw(Graphics g) {

		for (int x = 0; x < NumX; x++) {
			for (int y = 0; y < NumY; y++)
				g.drawImage(img, Code.TILE_SIZE * x, Code.TILE_SIZE * y, Code.TILE_SIZE * (x + 1), Code.TILE_SIZE * (y + 1),
						0, 0, width, height, GameCanvas.getInstance());
		}

	}

}
