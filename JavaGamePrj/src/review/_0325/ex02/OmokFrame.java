package review._0325.ex02;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OmokFrame extends Frame {

	private OmokCanvas canvas;

	public OmokFrame() {

		canvas = new OmokCanvas();
		add(canvas);
		pack();

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

}
