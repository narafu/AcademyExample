package review;

public class Review_0228_11a {

	public static void main(String[] args) {

		for (int j = 0; j < 5; j++) {
			for (int i = 1; i <= 10-j; i++) {
				System.out.print("¦¢");
				if (i % 5 == 0)
					System.out.print(" ");
			}
				System.out.println();
				System.out.println();
		}
	}
}
