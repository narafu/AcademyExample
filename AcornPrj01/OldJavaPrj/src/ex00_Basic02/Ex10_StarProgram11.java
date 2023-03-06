package ex00_Basic02;

public class Ex10_StarProgram11 {

	public static void main(String[] args) {

		for (int y = 1; y <= 10; y++) {

			System.out.printf("%d ", y - 1);

			for (int x = 1; x <= 10 - y; x++)
				System.out.print(" ¡Ù ");

			for (int x = 1; x <= y; x++)
				System.out.print(" ¡Ú ");

			System.out.print(" ¦¢");

			System.out.println();

		}

	}
}
