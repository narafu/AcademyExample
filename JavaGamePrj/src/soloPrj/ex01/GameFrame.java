package soloPrj.ex01;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	private static GameFrame gameFrame;
	private GameCanvas gameCanvas;
	private IntroCanvas introCanvas;

	public GameFrame() {
		gameFrame = this;
		introCanvas = new IntroCanvas();
		add(introCanvas);
		pack();
		setFocusable(true);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

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
		gameCanvas = new GameCanvas();
		add(gameCanvas);
		gameCanvas.start();
		gameCanvas.requestFocus();
		revalidate();

	}

}
