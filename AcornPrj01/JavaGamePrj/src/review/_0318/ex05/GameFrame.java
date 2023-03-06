package review._0318.ex05;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	GameCanvas canvas;

	public GameFrame() {

		canvas = new GameCanvas();
		this.add(canvas);
		canvas.start();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				int result = JOptionPane.showConfirmDialog(GameFrame.this, "³¡?");
				if (result == 0) {
					JOptionPane.showMessageDialog(GameFrame.this, "³¡!");
					System.exit(0);
				}
			}
		});
	}
}
