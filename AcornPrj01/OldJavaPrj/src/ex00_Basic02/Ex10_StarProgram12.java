package ex00_Basic02;

public class Ex10_StarProgram12 {

	public static void main(String[] args) {

		for (int y = 0; y < 10; y++) {

			System.out.printf("%d ", y);

			for (int x = 0; x < y + 1; x++)
				System.out.print("¡Ú");

			for (int x = 0; x < 9 - y; x++)
				System.out.print("¡Ù");

			System.out.println();

		}

	}
}
