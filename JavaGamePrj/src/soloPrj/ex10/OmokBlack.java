package soloPrj.ex10;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OmokBlack implements Omok {

	private static Image img;
	private double dx, dy, vx, vy, x, y;
	private int width, height;

	static {
		try {
			img = ImageIO.read(new File("res/image/omokblack.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "흑돌이미지가 없습니다.");
		}
	}

	public OmokBlack() {
		this(0, 0);
	}

	public OmokBlack(int dx, int dy) {
		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());
		
		this.x = dx;
		this.y = dy;

//		Random rand = new Random();
//		for (int i = 0; i < 10; i++) {
//			int x = rand.nextInt(100) + 50;
//			int y = rand.nextInt(100) + 50;
//		}

	}

	public void move(int dx, int dy) {

//		this.dx = dx;
//		this.dy = dy;
//		double w = dx - x;
//		double h = dy - y;
//		double d = Math.sqrt(w * w + h * h);
//		double vx = w / d;
//		double vy = h / d;

	}

	@Override
	public void dateUp() {

//		x += vx;
//		y += vy;
//
//		if (Math.abs(dx - x) < Math.abs(vx))
//			vx = vy = 0;

//		if (index == omoks.length) {
//			Omok[] temp = new Omok[omoks.length + 10];
//			for (int i = 0; i < index; i++) {
//				temp[i] = omoks[i];
//			}
//			omoks = temp;
//		}
//
	}

	@Override
	public void draw(Graphics g) {

		g.drawImage(img, (int) x, (int) y, width, height, GameCanvas.getInstance());

	}

}
