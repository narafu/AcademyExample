package teamPrj.ex00;

import java.awt.Frame;

public class Program {

	public static void main(String[] args) {

		Frame frame = new GameFrame();

		frame.pack();
		frame.setSize(1215, 935);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Team Project");

	}
}