package review;

import java.util.Random;

public class Review_0229_07 {

	public static void main(String[] args) {

		Random random = new Random();
		int n = 6;
		int[] lotto = new int[n];

		for (int i = 0; i < n; i++)
			lotto[i] = random.nextInt(45) + 1;

		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}

		for (int i = 0; i < n; i++)
			System.out.printf("%d ", lotto[i]);

	}
}
