package review._0323.ex03;

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
		setFocusable(true);
		add(introCanvas);
		introCanvas.start();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "EXIT ???");
				if (result == 0)
					JOptionPane.showMessageDialog(GameFrame.this, "EXIT !!!");
				System.exit(0);
			}
		});
	}

	public static GameFrame getInstance() {
		return gameFrame;
	}

	public void changeCanvas() {

		remove(introCanvas);
		add(gameCanvas);
		gameCanvas.requestFocus();
		gameCanvas.start();
		revalidate();

	}

}
