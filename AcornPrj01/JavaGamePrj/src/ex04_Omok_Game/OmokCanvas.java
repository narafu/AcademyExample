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
	// 오목을 추가할 위치를 기억하기 위한 변수 omokIndex를 추가하고 0으로 초기화해주세요.
	private int width, height, omokIndex, top;

	public OmokCanvas() {
		// canvas는 한번만 생성되므롸, 굳이 static으로 할 필요가 없다.
		// static은 생성 전에, 생성자는 객체를 생성하면서 load한다.

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
				// 오목 객체를 생성해서 omoks 배열에 omokIndex가 가리키는 위치에 추가해주세요.
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
					JOptionPane.showMessageDialog(OmokCanvas.getInstance(), "더 이상 오목알이 없습니다.");
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
					update(); // 점진적 변화
					repaint(); // 초당 60번씩 다시 그린다.
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

		// 오목 그리기
		// omoks 항목들을 반복적으로 꺼내서 i번째 오목에게 draw(g)를 요청한다.
		for (int i = 0; i < omokIndex; i++)
			omoks[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);
	}
}
