package project_01.TileGameExample01;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Window {
	public static final long SECOND = 1000000000;
	public static final long RENDER_FPS = (long) (SECOND / 60.0);
	private Frame frame;
	private Canvas canvas;
	private BufferStrategy bufferStrategy;
	private long frameCount;
	private boolean isShowInfo;
	protected boolean isClosing;
	protected boolean[] pressedKeys = new boolean[128];
	protected int mouseX;
	protected int mouseY;

	public Window(String title, int width, int height) {
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.addMouseListener(new MouseHandler(this));
		canvas.addMouseMotionListener(new MouseHandler(this));
		canvas.addKeyListener(new KeyboardHandler(this));
		frame = new Frame();
		frame.add(canvas);
		frame.pack();
		frame.setTitle(title);
		frame.setResizable(false);
		frame.addWindowListener(new WindowHandler(this));
		frame.addKeyListener(new KeyboardHandler(this));
		frame.setLocationRelativeTo(null);
		frame.createBufferStrategy(2);
		frame.setVisible(true);
	}

	protected abstract void draw(Graphics graphics);

	protected abstract void clicked(int x, int y);

	protected boolean isKeyPressed(int keyCode) {
		return pressedKeys[keyCode];
	}

	public void start() {
		long prevRenderTime = 0;
		long prevSecondTime = 0;
		long currentFrameCount = 0;
		while (isClosing == false) {
			long currentTime = System.nanoTime();
			if (currentTime - prevSecondTime > SECOND) {
				prevSecondTime = currentTime;
				frameCount = currentFrameCount;
				currentFrameCount = 0;
			}
			if (currentTime - prevRenderTime < RENDER_FPS)
				continue;
			prevRenderTime = currentTime;
			currentFrameCount += 1;

			bufferStrategy = canvas.getBufferStrategy();
			if (bufferStrategy == null) {
				canvas.createBufferStrategy(2);
				continue;
			}
			Graphics graphics = bufferStrategy.getDrawGraphics();
			if (graphics == null)
				continue;
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
			draw(graphics);
			if (isShowInfo) {
				graphics.setColor(Color.WHITE);
				graphics.drawString(String.format("FPS: %d", frameCount), 1, 15);
				graphics.drawString(String.format("Mouse-X: %d", mouseX), 1, 30);
				graphics.drawString(String.format("Mouse-Y: %d", mouseY), 1, 45);
			}
			graphics.dispose();
			if (bufferStrategy == null)
				continue;
			bufferStrategy.show();

			long elapsed = System.nanoTime() - prevRenderTime;
			long milliSleep = (RENDER_FPS - elapsed) / SECOND;
			if (milliSleep < 0)
				continue;
			try {
				Thread.sleep(0);
			} catch (InterruptedException ex) {
			}
		}
		frame.dispose();
	}

	class WindowHandler extends WindowAdapter {
		private Window window;

		public WindowHandler(Window window) {
			this.window = window;
		}

		public void windowClosing(WindowEvent windowEvent) {
			window.isClosing = true;
		}
	}

	public class KeyboardHandler implements KeyListener {
		private Window window;

		public KeyboardHandler(Window window) {
			this.window = window;
		}

		public void keyPressed(KeyEvent e) {
			window.pressedKeys[e.getKeyCode()] = true;
		}

		public void keyReleased(KeyEvent e) {
			window.pressedKeys[e.getKeyCode()] = false;
			if (e.getKeyCode() == KeyEvent.VK_F1)
				isShowInfo = !isShowInfo;
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	public class MouseHandler implements MouseListener, MouseMotionListener {
		Window window;

		public MouseHandler(Window window) {
			this.window = window;
		}

		public void mouseReleased(MouseEvent e) {
			window.clicked(e.getX(), e.getY());
		}

		public void mouseMoved(MouseEvent e) {
			window.mouseX = e.getX();
			window.mouseY = e.getY();
		}

		public void mouseDragged(MouseEvent e) {
			window.mouseX = e.getX();
			window.mouseY = e.getY();
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}
	}
}
