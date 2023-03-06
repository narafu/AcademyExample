package ex03_ShootingGame.ui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ShootingFrame extends Frame {

	private static ShootingFrame shootingFrame;

	private ShootingCanvas shootingCanvas;
	private IntroCanvas introCanvas;

	public ShootingFrame() {
		shootingFrame = this;
		introCanvas = new IntroCanvas();
		add(introCanvas);
		introCanvas.setFocusable(true);
		// 입력받아야할 곳을 포커스해준다.
		introCanvas.start();

		this.addWindowListener(new WindowAdapter() { // cf) WindowListener()
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(ShootingFrame.this, "종료하시겠습니까?");
				if (result == 0) {
					JOptionPane.showMessageDialog(ShootingFrame.this, "종료합니다.");
					System.exit(0);
				}
			}
		});
	}

	public static ShootingFrame getInstance() {
		return shootingFrame;
	}

	public void changeCanvas(int canvasId) {

		if (canvasId == 2) { // 캔버스가 여러개일 경우
			remove(introCanvas);
			shootingCanvas = new ShootingCanvas();
			add(shootingCanvas);
			shootingCanvas.start();
			// shootingCanvas.setFocusable(true);
			shootingCanvas.requestFocus(); // 포커스
			revalidate(); // canvas 변경 후 화면 다시 구성
		}

	}

}
