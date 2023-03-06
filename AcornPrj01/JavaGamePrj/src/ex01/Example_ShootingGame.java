package ex01;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Example_ShootingGame {

	public static void main(String[] args) {

		Frame frame = new Frame();
		frame.setVisible(true);
		frame.setSize(1000, 1000);

		Canvas canvas = new Canvas();
		frame.add(canvas);

		Image img;
		try {
			img = ImageIO.read(new File("res/image/fighter1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		canvas.paint(g);
		
		
		

	}

}
