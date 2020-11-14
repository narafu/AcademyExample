package ex01;
import java.awt.Frame;

public class Program02 {

	public static void main(String[] args) {

		/* Game */Frame frame = new GameFrame02();

		frame.setVisible(true);
		// -> repaint()
		// -> update()
		// -> paint()
		frame.setSize(1000, 700);

	}

}
