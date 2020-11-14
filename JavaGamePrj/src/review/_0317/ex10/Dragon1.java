package review._0317.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dragon1 {

	private Image img1;
	private int w1, h1;

	public Dragon1() {

		try {
			img1 = ImageIO.read(new File("res/image/dragon1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w1 = img1.getWidth(GameCanvas.getInstance());
		h1 = img1.getHeight(GameCanvas.getInstance());
	}

	public void draw(Graphics g) {
		// °¡¿îµ¥
		g.drawImage(img1, 
				800 - w1 / 2, 500 - h1 / 2, 800 + w1 / 2, 500 + h1 / 2, 
				0, 0, w1, h1,
				GameCanvas.getInstance());
	}

}
