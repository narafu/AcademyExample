package review._0323.ex02;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	private static GameFrame gameFrame;
	private IntroCanvas introCanvas = new IntroCanvas();
	private GameCanvas gameCanvas = new GameCanvas();

	public GameFrame() {
		gameFrame = this;
		introCanvas.setFocusable(true);
		add(introCanvas);
		introCanvas.start();
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				int result = JOptionPane.showConfirmDialog(GameFrame.this, "끝?");
				if (result == 0) {
					JOptionPane.showMessageDialog(GameFrame.this, "종료합니다.");
					System.exit(0);
				}
			}
		});
	}

	public static GameFrame getInstance() {
		return gameFrame;
	}

	public void changeCanvas() {
		remove(introCanvas);
		add(gameCanvas);
		gameCanvas.start();
		gameCanvas.requestFocus();
		revalidate();

	}

}
