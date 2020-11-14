package review._0317.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dragon3 {

	private Image img3;
	private int w3, h3;

	public Dragon3() {

		try {
			img3 = ImageIO.read(new File("res/image/dragon3.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w3 = img3.getWidth(GameCanvas.getInstance());
		h3 = img3.getHeight(GameCanvas.getInstance());
	}

	public void draw(Graphics g) {
		// ¾Æ - ¿Þ
		g.drawImage(img3, 50, 900 - h3, w3+50, 900, 0, 0, w3, h3, GameCanvas.getInstance());

	}

}
