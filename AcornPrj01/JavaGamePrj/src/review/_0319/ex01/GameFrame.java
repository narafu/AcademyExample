package review._0319.ex01;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {

	private GameCanvas canvas;
	private GameThread thread;

	public GameFrame() {

		thread = new GameThread();
		this.canvas = new GameCanvas();
		this.add(canvas);

//		thread.start();
		canvas.start();

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "�����Ͻðڽ��ϱ�?");
				if (result == 0) {
					JOptionPane.showMessageDialog(GameFrame.this, "�����մϴ�");
					System.exit(0);
				}
			}
		});
	}
}
