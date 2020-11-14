package ex00_Basic02;

public class Ex10_StarProgram09 {

	public static void main(String[] args) {

		System.out.print(" ");
		for (int x = 0; x < 10; x++)
			System.out.printf("%d", x);
		System.out.println();

		for (int y = 0; y < 10; y++) {
			System.out.printf("%d", y);
			for (int x = 0; x < 10 - y; x++)

				System.out.print("¡Ù");

			System.out.println();
		}

		System.out.print(" ");
		for (int x = 0; x < 10; x++)
			System.out.printf("%d", x);
		System.out.println();

	}
}
