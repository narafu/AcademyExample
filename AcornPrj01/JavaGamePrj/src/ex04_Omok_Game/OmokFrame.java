package ex04_Omok_Game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OmokFrame extends Frame /* is��� */ {

	private OmokCanvas canvas;

	// Ȯ��� ����� ���Ŷ�� Ȯ��� �̸���, Ȯ��� ����� ���� ���� �Ŷ�� ��ҵ� �̸��� ����Ѵ�.
	// �� ���, Ȯ��� ����� ����ϰ��� Canvas�� �ƴ� OmokCanvas�� ����Ͽ���.
	// OmokFrame�� Frame���κ��� is ��� �ް�, OmokCanvas�� has ������� ���´�.

	public OmokFrame() {

		canvas = new OmokCanvas(); // has ���
		add(canvas); // frame�� canvas�� ���δ�. canvas ũ��� frame ũ�⿡ ��������.
		canvas.start();
		pack();
//		setSize(775, 800);
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
