package teamPrj.ex04;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OmokFrame extends Frame /* is상속 */ {

	private OmokCanvas canvas;

	// 확장된 기능을 쓸거라면 확장된 이름을, 확장된 기능을 쓰지 않을 거라면 축소된 이름을 사용한다.
	// 이 경우, 확장된 기능을 사용하고자 Canvas가 아닌 OmokCanvas로 사용하였다.
	// OmokFrame은 Frame으로부터 is 상속 받고, OmokCanvas를 has 상속으로 갖는다.

	public OmokFrame() {

		canvas = new OmokCanvas(); // has 상속
		add(canvas); // frame에 canvas를 붙인다. canvas 크기는 frame 크기에 맞춰진다.
		canvas.start();
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
