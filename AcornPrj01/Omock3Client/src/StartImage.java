


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StartImage implements Movable {

	private static Image img;

	static {
		try {
			img = ImageIO.read(new File("res/image/intro.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StartImage() {

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, 380, 500, 900, 700, 0, 0, 520, 228, IntroCanvas.getInstance());
	}

}
