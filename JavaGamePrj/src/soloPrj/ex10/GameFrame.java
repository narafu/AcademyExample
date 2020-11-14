package soloPrj.ex10;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {

	private static GameFrame gameFrame;
	private IntroCanvas introCanvas;
	private GameCanvas gameCanvas;

	public GameFrame() {
		gameCanvas = new GameCanvas();
		introCanvas = new IntroCanvas();
		add(introCanvas);
		add(gameCanvas);
		gameCanvas.setSize(gameCanvas.CANVAS_WIDTH, gameCanvas.CANVAS_HEIGHT);
		pack();
		setFocusable(true);
		setLocationRelativeTo(null);
//		setResizable(false);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static GameFrame getInstance() {
		return gameFrame;
	}

	public void changeCanvas() {
		remove(introCanvas);
		revalidate();
		gameCanvas.requestFocus();
		gameCanvas.start();
	}

}
