package teamPrj.ex00;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bomb implements Movable {

	private int x;
	private int y;
	private int width, height, imgIndex, delay, unitIndex;
	private static Image bomb;
	private Effect effect;
	private Movable[] items;

	static {
		try {
			bomb = ImageIO.read(new File("res/image/bomb1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Bomb(double x, double y) {
		this.x = (int) x;
		this.y = (int) y;
		width = bomb.getWidth(GameCanvas.getInstance());
		height = bomb.getHeight(GameCanvas.getInstance());
	}

	public Bomb() {
		this(0, 0);
//      effect = new Effect();
//      items[unitIndex++]= effect;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		x = (int) (Math.floor(x / 60) * 60) + 30;
		y = (int) (Math.floor(y / 60) * 60) + 30;
		g.drawImage(bomb, x - 30, y - 30, x + 30, y + 30, 0, 0, 225, 225, GameCanvas.getInstance());

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}