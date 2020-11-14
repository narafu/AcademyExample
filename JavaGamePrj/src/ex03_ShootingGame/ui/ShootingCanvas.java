package ex03_ShootingGame.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import ex03_ShootingGame.item.Enemy;
import ex03_ShootingGame.item.Fighter;
import ex03_ShootingGame.item.Missile;
import ex03_ShootingGame.item.Movable;
import ex03_ShootingGame.item.Space;

public class ShootingCanvas extends Canvas {

	private static ShootingCanvas canvas;
	public static final int N = 1; // 0001
	public static final int E = 2; // 0010
	public static final int S = 4; // 0100
	public static final int W = 8; // 1000
	private Space space;
	private Fighter fighter;
	private Enemy enemy;
	private Random rand;
	private Movable[] items;
	private int unitIndex, direction, countDown, max;

	public ShootingCanvas() {
		canvas = this;
		space = new Space();
		enemy = new Enemy();
		fighter = new Fighter();
		rand = new Random();
		countDown = rand.nextInt(120) + 60;
		max = 10;
		items = new Movable[max]; // (���� ���� �� �ִ�)�迭 ����
		items[unitIndex++] = space;
		items[unitIndex++] = fighter;
		items[unitIndex++] = enemy;

		this.addMouseListener(new MouseAdapter() { // cf) MouseListener()
			@Override
			public void mouseClicked(MouseEvent e) {
				fighter.move(e.getX(), e.getY());
				/* ShootingCanvas.this. */repaint();
			}
		});

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
//				e.getKeyChar();
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
//					fighter.moveLeft();
					direction |= W;
					break;
				case KeyEvent.VK_UP:
//					fighter.moveUp();
					direction |= N;
					break;
				case KeyEvent.VK_RIGHT:
//					fighter.moveRight();
					direction |= E;
					break;
				case KeyEvent.VK_DOWN:
//					fighter.moveDown();
					direction |= S;
					break;
				case KeyEvent.VK_SPACE:
					Missile ms = fighter.fire();
					items[unitIndex++] = ms;
					break;
				}
				fighter.move(direction);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				fighter.setImgindex(3);

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					direction &= ~W;
					break;
				case KeyEvent.VK_UP:
					direction &= ~N;
					break;
				case KeyEvent.VK_RIGHT:
					direction &= ~E;
					break;
				case KeyEvent.VK_DOWN:
					direction &= ~S;
					break;
				}
				fighter.move(direction);
			}
		});
	}

	public void start() {

		Thread gameThread = new Thread(new Runnable() {

			@Override
			public void run() { // ���ο� �帧�� ���� �Լ�
				while (true) {
					/* ShootingCanvas. */dateUp(); // ���� ���� ������ ������ /* ShootingCanvas.this.
					repaint();
					try {
						Thread.sleep(17); // 1�� = 1000
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();

	}

	public static ShootingCanvas getInstance() {
		return canvas;
	}

	public void dateUp() {
		for (int i = 0; i < unitIndex; i++)
			items[i].dateUp();
		if (--countDown == 0) {
			Enemy enemy = new Enemy();

			if (unitIndex == max) {
				Movable[] temp = new Movable[max + 10];
				for (int i = 0; i < unitIndex; i++) {
					temp[i] = items[i];
				}
				items = temp;
				max += 10;
			}

			items[unitIndex++] = enemy;
			rand = new Random();
			countDown = rand.nextInt(120) + 60;
		}
	}

	@Override // �޼ҵ� ������
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();

		// ���۸��� �׸��� ������ �غ��ؾ��Ѵ�. (g�� �׸��� �����쵵ȭ��, gg�� �׸��� ��Ʈ��)

		for (int i = 0; i < unitIndex; i++)
			items[i].draw(gg);

		// ��� �׸��� �� �׷�����, �ѹ��� ȭ�� ���ۿ� �׸���.
		g.drawImage(buf, 0, 0, this);

//		space.draw(g);
//		fighter.draw(g);
//		enemy.draw(g);

//		g.setColor(Color.red);
//		g.drawRect(500, 900, 3, 3);
	}

}
