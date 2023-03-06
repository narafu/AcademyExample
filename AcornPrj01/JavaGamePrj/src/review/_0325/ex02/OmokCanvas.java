package review._0325.ex02;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OmokCanvas extends Canvas {

	private static OmokCanvas omokCanvas;
	private Image img;
	private Omok omok;
	private Omok[] omoks;
	private int width, height, omokIndex;

	public OmokCanvas() {

		try {
			img = ImageIO.read(new File("res/image/omokboard.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		omokCanvas = this;
		omoks = new Omok[100];
		width = img.getWidth(this);
		height = img.getHeight(this);
		setSize(width, height);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int x = e.getX();
				int y = e.getY();
				x = (int) Math.floor(x / 40) * 40 + 20;
				y = (int) Math.floor(y / 40) * 40 + 20;

				omoks[omokIndex++] = new Omok(x, y);

				repaint();

			}
		});

	}

	public static OmokCanvas getInstance() {
		return omokCanvas;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics bufG = buf.getGraphics();

		bufG.drawImage(img, 0, 0, this);

		for (int i = 0; i < omokIndex; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);

	}

}
