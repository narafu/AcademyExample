package soloPrj.ex08_bombman;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends Frame {

	private GameCanvas canvas;

	public GameFrame() {

		canvas = new GameCanvas();
		add(canvas);
		pack();
		canvas.setFocusable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		canvas.start();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}
