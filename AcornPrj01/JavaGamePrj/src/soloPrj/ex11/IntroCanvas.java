package soloPrj.ex11;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class IntroCanvas extends Canvas {

	private static Image img;
	private static IntroCanvas canvas;
	private Cursor cursorHand, cursorDefault;
	private int width, height;

	static {

		try {
			img = ImageIO.read(new File("res/image/intro.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(IntroCanvas.getInstance(), "바탕이미지가 없습니다.");
		}

	}

	public IntroCanvas() {
		canvas = this;
		width = img.getWidth(this);
		height = img.getHeight(this);
		setSize(250 + 760 + 250, 760);

		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				if ((520 < e.getX()) && (e.getX() < 720) && (280 < e.getY()) && (e.getY() < 480)) {
					cursorHand = new Cursor(Cursor.HAND_CURSOR);
					setCursor(cursorHand);
				} else {
					cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);
					setCursor(cursorDefault);
				}
			}
		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((520 < e.getX()) && (e.getX() < 720) && (280 < e.getY()) && (e.getY() < 480))
					GameFrame.getInstance().changeCanvas();
			}
		});
	}

	public static IntroCanvas getInstance() {
		return canvas;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics bufG = buf.getGraphics();

		bufG.drawImage(img, 1240 / 2 - width / 2, 760 / 2 - height / 2, 1240 / 2 + width / 2, 760 / 2 + height / 2, 0,
				0, width, height, this);

		g.drawImage(buf, 0, 0, this);

	}

}
