package ex00_Basic02;

public class Ex11_OmokProgram01 {

	public static void main(String[] args) {

		int width = 20;
		int height = 20;
		
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)

				if (y == 1 && x == 1)
					System.out.print("忙式");
				else if (y == 1 && x == 20)
					System.out.print("忖");
				else if (y == height && x == 1)
					System.out.print("戌式");
				else if (y == height && x == 20)
					System.out.print("戎");

				else if (y == 1)
					System.out.print("成式");
				else if (x == 1)
					System.out.print("戍式");
				else if (x == width)
					System.out.print("扣");
				else if (y == height)
					System.out.print("扛式");

				else
					System.out.print("托式");
			System.out.println();
		}

	}
}
