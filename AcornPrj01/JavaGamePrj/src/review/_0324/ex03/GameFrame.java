package review._0324.ex03;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	private static GameFrame gameFrame;
	private IntroCanvas introCanvas;
	private GameCanvas gameCanvas;

	public GameFrame() {
		gameFrame = this;
		introCanvas = new IntroCanvas();
		gameCanvas = new GameCanvas();

		add(introCanvas);
		setFocusable(true);
		introCanvas.start();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				int result = JOptionPane.showConfirmDialog(GameFrame.this, "³¡?!?!?!?");
				if (result == 0)
					System.exit(0);
			}
		});
	}

	public static GameFrame getInstance() {
		return gameFrame;
	}

	public void changeCanvas(int canvasId) {
		if (canvasId == 2) {

			remove(introCanvas);
			add(gameCanvas);
			gameCanvas.start();
			gameCanvas.requestFocus();
			revalidate();

		}

	}

}
