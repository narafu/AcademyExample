package review._0317.ex06;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	private GameCanvas canvas;

	public GameFrame() {
		canvas = new GameCanvas();
		this.add(canvas);

		canvas.start();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "종료?!?!?");
				if (result == 0) {
					JOptionPane.showMessageDialog(GameFrame.this, "종료합니다.");
					System.exit(0);
				}

			}

		});
	}

}
