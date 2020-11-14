package review._0325.ex03;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameCanvas extends Canvas {

	private static GameCanvas omokCanvas;
	private Image img;
	private int width, height, omokIndex;

	public GameCanvas() {

		try {
			img = ImageIO.read(new File("res/image/omokboard.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		omokCanvas = this;
		width = img.getWidth(this);
		height = img.getHeight(this);
		setSize(width, height);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

	}

	public static GameCanvas getInstance() {
		return omokCanvas;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, this);

	}

}
