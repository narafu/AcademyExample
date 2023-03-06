package ex04_Omok_Game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class OmokCanvas extends Canvas {

	private static OmokCanvas omokCanvas;
	private Image img;
	private Omok omok;
	private Omok[] omoks;
	// ������ �߰��� ��ġ�� ����ϱ� ���� ���� omokIndex�� �߰��ϰ� 0���� �ʱ�ȭ���ּ���.
	private int width, height, omokIndex, top;

	public OmokCanvas() {
		// canvas�� �ѹ��� �����ǹǷ�, ���� static���� �� �ʿ䰡 ����.
		// static�� ���� ����, �����ڴ� ��ü�� �����ϸ鼭 load�Ѵ�.

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
		top = -1;

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			int x = rand.nextInt(20) + 10;
			int y = rand.nextInt(20) + 10;
			omoks[omokIndex++] = new Omok(x, y);
			top++;
		}

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ���� ��ü�� �����ؼ� omoks �迭�� omokIndex�� ����Ű�� ��ġ�� �߰����ּ���.
				int x = e.getX();
				int y = e.getY();
				x = (int) (Math.floor(x / 40) * 40);
				y = (int) (Math.floor(y / 40) * 40);

				try {
					omok = omoks[top--];
//					omok.setX(x);
//					omok.setY(y);
					omok.move(x, y);
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "�� �̻� ������� �����ϴ�.");
				}
//				repaint(); // -> update(g) -> paint(g);
			}
		});

	}

	public static OmokCanvas getInstance() {
		return omokCanvas;
	}

	public void start() {

		Thread gamethread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					update(); // ������ ��ȭ
					repaint(); // �ʴ� 60���� �ٽ� �׸���.
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		gamethread.start();

	}

	public void update() {

		for (int i = 0; i < omokIndex; i++)
			omoks[i].update();

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(getWidth(), getHeight());
		Graphics bufG = buf.getGraphics();

//		g.drawImage(img, 0, 0, width, height, 0, 0, width, height, this);
		bufG.drawImage(img, 0, 0, this);

		// ���� �׸���
		// omoks �׸���� �ݺ������� ������ i��° ���񿡰� draw(g)�� ��û�Ѵ�.
		for (int i = 0; i < omokIndex; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);
	}
}
