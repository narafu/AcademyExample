package ex00_Basic02;

public class Ex10_StarProgram13 {

	public static void main(String[] args) {

		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++)
				if (x <= y)
					System.out.print("¡Ú ");
				else
					System.out.print("¡Ù ");

			System.out.println();
		}
	}
}
