package ex00_Basic02;

public class Ex10_StarProgram05 {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			if (i == 2)
				System.out.print("¡Ù");

			if (i == 2)
				System.out.print("¡á");
			else if (i == 1 || i == 4)
				System.out.print("¡Ý");

			if (i == 3)
				System.out.print("¡Ú");
			else
				System.out.print("¡Û");

			System.out.println("¡Ü");
		}
	}

}
