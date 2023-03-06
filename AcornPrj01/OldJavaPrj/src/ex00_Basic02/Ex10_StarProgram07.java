package ex00_Basic02;

public class Ex10_StarProgram07 {

	public static void main(String[] args) {

		for (int y = 0; y < 10; y++) {
			System.out.printf("%d", y);
			for (int x = 0; x < 10 - y; x++)
				System.out.print("¡Ù");

			System.out.println();
		}
	}

}
