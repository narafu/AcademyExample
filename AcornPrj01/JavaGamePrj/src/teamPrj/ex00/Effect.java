package teamPrj.ex00;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Effect implements Movable {

	private int x;
	private int y;
	private int width, height, width1, height1, imgIndex, imgIndex2;
	private int delay;
	private int tilewidth;
	private int unitIndex;
	private Movable[] items;
	private static Image effect, effect1;
	private int offsetX, offsetY;

	static {
		try {
			effect = ImageIO.read(new File("res/image/effect.png")); // ¼¼·Î
			effect1 = ImageIO.read(new File("res/image/effect1.png")); // °¡·Î
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Effect(double x, double y) {
		this.x = (int) x;
		this.y = (int) y;
		width = effect.getWidth(GameCanvas.getInstance()) / 7;
		height = effect.getHeight(GameCanvas.getInstance()) / 3;
		width1 = effect1.getWidth(GameCanvas.getInstance()) / 2;
		height1 = effect1.getHeight(GameCanvas.getInstance()) / 7;
		imgIndex = 1;
		imgIndex2 = 7;
		delay = 8;
		tilewidth = 60;
		offsetX = 30;
		offsetY = 30;
	}

	public Effect() {
		this(0, 0);

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

		if (delay-- == 0) {
			imgIndex++;
			imgIndex2--;
			delay = 8;

		}
	}

	@Override
	public void draw(Graphics g) {
		x = (int) (Math.floor(x / 60) * 60);
		y = (int) (Math.floor(y / 60) * 60);
		// Áß¾Ó ¾Ë¸ÍÀÌ¶û ¿À¸¥ÂÊ¹æÇâ ¾Ë¸ÍÀÌ
		for (int i = 1; i < 4; i++) {
			g.drawImage(effect, x + ((i - 1) * tilewidth), y, x + tilewidth * i, y + tilewidth, (imgIndex - 1) * width,
					height * (i - 1) + 4, imgIndex * width, height * i, GameCanvas.getInstance());
		}
		// Áß¾Ó•û°í ¿ÞÂÊ ¹æÇâ ¾Ë¸ÍÀÌ
		for (int i = 1; i < 3; i++) {
			g.drawImage(effect, x - ((i - 1) * tilewidth), y, x - (i * tilewidth), y + tilewidth,
					(imgIndex - 1) * width, (i * height) + 4, imgIndex * width, height * (i + 1),
					GameCanvas.getInstance());
		}
		for (int i = 1; i < 3; i++) {
			g.drawImage(effect1, x, y - (tilewidth * i), x + tilewidth, y - (tilewidth * (i - 1)), width1 * (i - 1),
					height1 * (imgIndex2 - 1), width1 * i, height1 * imgIndex2, GameCanvas.getInstance());
		}
		for (int i = 1; i < 3; i++) {
			g.drawImage(effect1, x, y + (tilewidth * (i + 1)), x + tilewidth, y + (tilewidth * i), width1 * (i - 1),
					height1 * (imgIndex2 - 1), width1 * i, height1 * imgIndex2, GameCanvas.getInstance());
		}
		// ¼¼·ÎÀ§¿¡ Áß¾Ó¾Ë¸ÍÀÌ
//      g.drawImage(effect1, x, y-height, x+width, y,
//            width*0, height1*(imgIndex2-1), width1, height*imgIndex2, TeamCanvas.getInstance());
//      // ¼¼·ÎÀ§¿¡ ²ôÆ®¸Ó¸®
//      g.drawImage(effect1, x, y-(height*2), x+width, y - (height*1),
//            width1, height1*(imgIndex2-1), width1*2, height1*imgIndex2, TeamCanvas.getInstance());
		// ¼¼·Î¾Æ·¡ Áß¾Ó¾Ë¸ÍÀÌ
//      g.drawImage(effect1, x, y+ height1*2, x+width1, y+height1,
//            width1*0, height1*(imgIndex2-1), width1*1, height1*imgIndex2, TeamCanvas.getInstance());
		// ¼¼·Î¾Æ·¡ ²ôÆ®¸Ó¸®
//      g.drawImage(effect1, x, y+ height1*3, x+width1, y+height1*2,
//            width1, height1*(imgIndex2-1), width1*2, height1*imgIndex2, TeamCanvas.getInstance());

	}

}