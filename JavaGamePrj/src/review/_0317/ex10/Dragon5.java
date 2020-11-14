package review._0317.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dragon5 {

	private Image img5;
	private int w5, h5;

	public Dragon5() {

		try {
			img5 = ImageIO.read(new File("res/image/dragon5.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w5 = img5.getWidth(GameCanvas.getInstance());
		h5 = img5.getHeight(GameCanvas.getInstance());
	}

	public void draw(Graphics g) {
		// À§ - ¿À
		g.drawImage(img5, 1550 - w5, 50, 1550, h5+50, 0, 0, w5, h5, GameCanvas.getInstance());

	}

}
