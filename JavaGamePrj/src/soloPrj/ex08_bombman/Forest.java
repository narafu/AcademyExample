package soloPrj.ex08_bombman;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Forest implements Unit {

	private static Image img;
	private int width, height;
	private double x, y;

	static {
		try {
			img = ImageIO.read(new File("res/image/forest.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "image error");
		}
	}

	public Forest() {

		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dateUp() {
		// TODO Auto-generated method stub

	}

}
