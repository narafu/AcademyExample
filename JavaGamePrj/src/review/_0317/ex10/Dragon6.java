package review._0317.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dragon6 {

	private Image img6;
	private int w6, h6;

	public Dragon6() {

		try {
			img6 = ImageIO.read(new File("res/image/dragon6.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w6 = img6.getWidth(GameCanvas.getInstance());
		h6 = img6.getHeight(GameCanvas.getInstance());
	}

	public void draw(Graphics g) {
		// ¾Æ - ¿À
		g.drawImage(img6, 1550 - w6, 900 - h6, 1500, 900, 0, 0, w6, h6, GameCanvas.getInstance());

	}

}
