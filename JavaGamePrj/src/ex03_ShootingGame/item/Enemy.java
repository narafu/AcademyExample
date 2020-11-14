package ex03_ShootingGame.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import ex03_ShootingGame.ui.ShootingCanvas;

public class Enemy implements Movable {

	private static Image img; // 전역변수는 한번만 생성한다. (그렇지 않으면 new할때마다 생성)
	private int width, height;
	private double x, y;
	private int imgIndex, timeOut;
	Random rand = new Random();

	// static 초기화영역(시작할 때 한번만)
	static {
		try {
			img = ImageIO.read(new File("res/image/alien.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Enemy() {
		width = img.getWidth(ShootingCanvas.getInstance()) / 12;
		height = img.getHeight(ShootingCanvas.getInstance());
		x = rand.nextInt(500) + 50;
		y = 150;
		timeOut = 3;
		imgIndex = 0;

	}

	public void dateUp() {

		if (timeOut-- == 0) {

			imgIndex++;
			imgIndex %= 12;
			timeOut = 3;
		}

		y += 1;
	}

	public void draw(Graphics g) {
		int offsetX = width / 2;
		int offsetY = height / 2;
		for (int i = 0; i < 5; i++) {
			int dx1 = (int) x - offsetX;
			int dy1 = (int) y - offsetY;
			int dx2 = (int) x + offsetX;
			int dy2 = (int) y + offsetY;

			g.drawImage(img, dx1, dy1, dx2, dy2, imgIndex * width, 0, (imgIndex + 1) * width, height,
					ShootingCanvas.getInstance());

		}
	}

}
