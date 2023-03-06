package review._0317.ex02;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GameFrame extends Frame {

	private Image img;

	public GameFrame() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		img = tk.getImage("res/image/dragon.jpg");

	}

	@Override
	public void paint(Graphics g) {

		int width = 1280;
		int height = 720;
		
		// �� - ��
		g.drawImage(img,
				0, 0, width/4, height/4,
				width/2, 0, width, height/2, this);
		// �� - �Ʒ�
		g.drawImage(img,
				0, height/4, width/4, height/2,
				0, 0, width/2, height/2, this);
		// �� - �Ʒ�
		g.drawImage(img,
				width/4, height/4, width/2, height/2,
				0, height/2, width/2, height, this);
		// �� - ��
		g.drawImage(img,
				width/4, 0, width/2, height/4,
				width/2, height/2, width, height,  this);
		
	}
	
	
}
