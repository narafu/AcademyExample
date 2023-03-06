package soloPrj.ex08_bombman;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Stone implements Unit {

	private static Image img;
	private int width, height;
	private double x, y;
	private int tileSize, tileNumX, tileNumY, stoneNumX, stoneNumY;
	private int[] stoneX, stoneY;

	static {
		try {
			img = ImageIO.read(new File("res/image/stone.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "image error");
		}
	}

	public Stone() {

		tileSize = GameCanvas.getInstance().TILE_SIZE; // 60
		tileNumX = GameCanvas.getInstance().TILE_NUM_X; // 20
		tileNumY = GameCanvas.getInstance().TILE_NUM_Y; // 15
		stoneNumX = tileNumX / 2;
		stoneNumY = tileNumY / 2;
		stoneX = new int[stoneNumX];
		stoneY = new int[stoneNumY];

		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());

		Random rand = new Random();
		for (int i = 0; i < stoneNumX; i++) {
			for (int j = 0; j < stoneNumY; j++) {
				stoneX[i] = rand.nextInt(tileNumX);
				stoneY[j] = rand.nextInt(tileNumY);
			}
		}

	}

	@Override
	public void draw(Graphics g) {

		g.drawImage(img, (int) x, (int) y, (int) x + tileSize, (int) y + tileSize, 0, 0, width, height,
				GameCanvas.getInstance());

	}

	@Override
	public void dateUp() {
		// TODO Auto-generated method stub

	}

}
