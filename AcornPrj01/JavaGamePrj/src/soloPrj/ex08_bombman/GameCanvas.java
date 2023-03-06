package soloPrj.ex08_bombman;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameCanvas extends Canvas {

	private static GameCanvas canvas;
	public final int TILE_SIZE = 60;
	public final int TILE_NUM_X = 20;
	public final int TILE_NUM_Y = 15;
	public final int NORTH = 1;
	public final int EAST = 2;
	public final int SOUTH = 4;
	public final int WEST = 8;
	private int direction, unitIndex;
	private Stone stone;
	private Forest forest;
	private Player player;
	private Bomb bomb;
	private Box box;
	private Grass grass;
	private Unit[] units;

	public GameCanvas() {
		canvas = this;
		setSize(TILE_NUM_X * TILE_SIZE, TILE_NUM_Y * TILE_SIZE);
//		grass = new Grass();
		stone = new Stone();
//		forest = new Forest();
		player = new Player();
//		bomb = new Bomb();
//		box = new Box();

		units = new Unit[100];

//		units[unitIndex++] = grass;
		units[unitIndex++] = stone;
//		units[unitIndex++] = forest;
		units[unitIndex++] = player;
//		units[unitIndex++] = bomb;
//		units[unitIndex++] = box;

		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					direction |= NORTH;
					break;
				case KeyEvent.VK_RIGHT:
					direction |= EAST;
					break;
				case KeyEvent.VK_DOWN:
					direction |= SOUTH;
					break;
				case KeyEvent.VK_LEFT:
					direction |= WEST;
					break;
				case KeyEvent.VK_SPACE:
					player.bomb();

				}
				player.move(direction);
			}

			@Override
			public void keyReleased(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					direction ^= NORTH;
					break;
				case KeyEvent.VK_RIGHT:
					direction ^= EAST;
					break;
				case KeyEvent.VK_DOWN:
					direction ^= SOUTH;
					break;
				case KeyEvent.VK_LEFT:
					direction ^= WEST;
					break;
				}
				player.move(direction);
				player.setImgIndexY(0);
			}

		});

	}

	public static GameCanvas getInstance() {
		return canvas;
	}

	public void start() {

		Thread gameThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					dateUp();
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void dateUp() {

		for (int i = 0; i < unitIndex; i++)
			units[i].dateUp();

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics bufG = buf.getGraphics();

		for (int x = 0; x < TILE_NUM_X; x++) {
			for (int y = 0; y < TILE_NUM_Y; y++) {
				bufG.drawRect(x * TILE_SIZE, y * TILE_SIZE, (x + 1) * TILE_SIZE, (y + 1) * TILE_SIZE);
			}
		}

		for (int i = 0; i < unitIndex; i++)
			units[i].draw(bufG);

		g.drawImage(buf, 0, 0, this);

	}
}
