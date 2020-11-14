package project_01.TileGameExample04;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class GameFrame extends Frame {
	private TeamCanvas canvas;

	public GameFrame() {
		canvas = new TeamCanvas();
		this.add(canvas);
		canvas.setFocusable(true);
		canvas.start();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "����?");
				if (result == 0) // ���α׷� ������
					System.exit(0);
			}
		});

	}
}