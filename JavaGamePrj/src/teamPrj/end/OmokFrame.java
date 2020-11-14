package teamPrj.end;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OmokFrame extends Frame {

	public static OmokFrame frame;
	private IntroCanvas introCanvas;
	private OmokCanvas omokCanvas;

	public OmokFrame() {
		frame = this;
		introCanvas = new IntroCanvas();
		add(introCanvas);
		setSize(1280, 800);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		introCanvas.setFocusable(true);
		introCanvas.start();

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public static OmokFrame getInstance() {
		return frame;
	}

	public void changeCanvas(int canvasID) {

		if (canvasID == 2) {
			omokCanvas = new OmokCanvas();
			remove(introCanvas);
			add(omokCanvas);
			revalidate();
			omokCanvas.requestFocus();
			omokCanvas.start();

		}
	}

}
