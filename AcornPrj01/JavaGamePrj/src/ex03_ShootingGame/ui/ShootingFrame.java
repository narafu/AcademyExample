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
		// �Է¹޾ƾ��� ���� ��Ŀ�����ش�.
		introCanvas.start();

		this.addWindowListener(new WindowAdapter() { // cf) WindowListener()
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(ShootingFrame.this, "�����Ͻðڽ��ϱ�?");
				if (result == 0) {
					JOptionPane.showMessageDialog(ShootingFrame.this, "�����մϴ�.");
					System.exit(0);
				}
			}
		});
	}

	public static ShootingFrame getInstance() {
		return shootingFrame;
	}

	public void changeCanvas(int canvasId) {

		if (canvasId == 2) { // ĵ������ �������� ���
			remove(introCanvas);
			shootingCanvas = new ShootingCanvas();
			add(shootingCanvas);
			shootingCanvas.start();
			// shootingCanvas.setFocusable(true);
			shootingCanvas.requestFocus(); // ��Ŀ��
			revalidate(); // canvas ���� �� ȭ�� �ٽ� ����
		}

	}

}
