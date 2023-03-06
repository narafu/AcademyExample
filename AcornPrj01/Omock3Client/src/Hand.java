


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Hand implements Movable {

	private int x1, y1, x2, y2;
	private static Image img;

	static {
		try {
			img = ImageIO.read(new File("res/image/hand.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Hand() {

		x1 = 0;
		y1 = 550;
		x2 = 1180;

	}

	@Override
	public void update() {

		x2 -= 2;
		if (x2 == 880)
			x2 = 1180;

		x1 += 2;
		if (x1 == 300)
			x1 = 0;

	}

	@Override
	public void draw(Graphics g) {

		g.drawImage(img, x1 + 100, y1, x1, y1 + 100, 0, 0, 278, 395, IntroCanvas.getInstance());
		g.drawImage(img, x2, y1, x2 + 100, y1 + 100, 0, 0, 278, 395, IntroCanvas.getInstance());
	}

}
