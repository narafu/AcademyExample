package ex00_Basic02;

public class Ex11_OmokProgram01 {

	public static void main(String[] args) {

		int width = 20;
		int height = 20;
		
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)

				if (y == 1 && x == 1)
					System.out.print("����");
				else if (y == 1 && x == 20)
					System.out.print("��");
				else if (y == height && x == 1)
					System.out.print("����");
				else if (y == height && x == 20)
					System.out.print("��");

				else if (y == 1)
					System.out.print("����");
				else if (x == 1)
					System.out.print("����");
				else if (x == width)
					System.out.print("��");
				else if (y == height)
					System.out.print("����");

				else
					System.out.print("����");
			System.out.println();
		}

	}
}
