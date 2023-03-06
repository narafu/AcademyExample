package review._0317.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dragon4 {

	private Image img4;
	private int w4, h4;

	public Dragon4() {

		try {
			img4 = ImageIO.read(new File("res/image/dragon4.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w4 = img4.getWidth(GameCanvas.getInstance());
		h4 = img4.getHeight(GameCanvas.getInstance());
	}

	public void draw(Graphics g) {
		// РЇ - Сп
		g.drawImage(img4, 800 - w4 / 2, 50, 800 + w4 / 2, h4 + 50, 0, 0, w4, h4, GameCanvas.getInstance());

	}

}
