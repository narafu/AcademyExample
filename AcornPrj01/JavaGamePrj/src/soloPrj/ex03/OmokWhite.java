package soloPrj.ex03;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OmokWhite implements Omok {

	private static Image img;
	private double dx, dy, vx, vy, x, y;
	private int width, height;

	static {
		try {
			img = ImageIO.read(new File("res/image/omokwhite.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(GameCanvas.getInstance(), "백돌이미지가 없습니다.");
		}
	}

	public OmokWhite() {
		this(0, 0);
	}

	public OmokWhite(int dx, int dy) {
		width = img.getWidth(GameCanvas.getInstance());
		height = img.getHeight(GameCanvas.getInstance());
		this.x = dx;
		this.y = dy;
	}

	@Override
	public void dateUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, (int) x + 12, (int) y, width, height, GameCanvas.getInstance());
	}

}
