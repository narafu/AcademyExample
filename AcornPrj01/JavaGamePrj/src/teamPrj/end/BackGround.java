package teamPrj.end;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackGround implements Movable {

	private static Image img;

	static {
		try {
			img = ImageIO.read(new File("res/image/ground.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		g.drawImage(img, 0, 0, 1280, 800, 0, 0, 1802, 1000, IntroCanvas.getInstance());
	}

}
