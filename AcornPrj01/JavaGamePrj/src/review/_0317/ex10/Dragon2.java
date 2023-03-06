package review._0317.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dragon2 {

	private Image img2;
	private int w2, h2;

	public Dragon2() {

		try {
			img2 = ImageIO.read(new File("res/image/dragon2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w2 = img2.getWidth(GameCanvas.getInstance());
		h2 = img2.getHeight(GameCanvas.getInstance());
	}

	public void draw(Graphics g) {
		// РЇ - По
		g.drawImage(img2, 50, 50, w2 + 50, h2 + 50, 0, 0, w2, h2, GameCanvas.getInstance());
	}

}
