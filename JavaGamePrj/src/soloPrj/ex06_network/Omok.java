package soloPrj.ex06_network;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Omok {

	private static final int BLACK = 1;
	private static final int WHITE = 2;
	private static Image img, imgWhite, imgBlack;
	private static boolean isblackTurn;
	private int width, height, color;
	private double dx, dy, vx, vy, w, h, d, x, y;

	static {
		isblackTurn = true;
		try {
			imgBlack = ImageIO.read(new File("res/image/omokblack.png"));
			imgWhite = ImageIO.read(new File("res/image/omokwhite.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Omok() {
		this(0, 0); // 오버로드
		color = BLACK; // 기본값
	}

	public Omok(int x, int y) {
		width = imgBlack.getWidth(OmokCanvas.getInstance());
		height = imgBlack.getHeight(OmokCanvas.getInstance());
		this.x = x;
		this.y = y;
		if (isblackTurn)
			this.color = BLACK;
		else
			this.color = WHITE;
		isblackTurn = !isblackTurn;
	}

	public void move(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void update() {
		x = dx;
		y = dy;
	}

	public void draw(Graphics g) {

		img = imgBlack;

		if (color == WHITE)
			img = imgWhite;

		g.drawImage(img, (int) x, (int) y, OmokCanvas.getInstance());

	}

}
