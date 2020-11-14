package review._0325.ex03;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OmokFrame extends Frame {

	private GameCanvas canvas;

	public OmokFrame() {
		canvas = new GameCanvas();
		add(canvas);
		pack();
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}
