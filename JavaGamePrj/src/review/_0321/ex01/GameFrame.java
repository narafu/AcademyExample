package review._0321.ex01;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	private GameCanvas canvas;

	public GameFrame() {

		canvas = new GameCanvas();
		canvas.start();
		canvas.setFocusable(true);
		add(canvas);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				int result = JOptionPane.showConfirmDialog(GameFrame.this, "끝낼까요?");
				if (result == 0) {
					JOptionPane.showMessageDialog(GameFrame.this, "종료합니다");
					System.exit(0);
				}
			}
		});
	}
}
