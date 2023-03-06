package review._0320;

import java.util.Random;

public class ·Î¶Ç {

	public static void main(String[] args) {

		Random random = new Random();
		int[] lotto = new int[6];

		for (int i = 0; i < 6; i++) {
			lotto[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				while (lotto[i] == lotto[j])
					lotto[i] = random.nextInt(45) + 1;
			}
		}

		for (int i = 0; i < 6 - 1; i++) {
			for (int j = 0; j < 6 - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);

	}

}
