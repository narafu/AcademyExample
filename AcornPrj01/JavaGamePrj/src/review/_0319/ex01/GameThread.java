package review._0319.ex01;

public class GameThread extends Thread {

	private GameCanvas canvas;

	public GameThread() {
		canvas = new GameCanvas();
	}

	@Override
	public void run() {
		while (true) {
			canvas.update();
			canvas.repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
