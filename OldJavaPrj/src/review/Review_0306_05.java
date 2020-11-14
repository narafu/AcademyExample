package review;

import java.util.Random;

public class Review_0306_05 {

	public static void main(String[] args) {

		// 로또(입력,정렬,출력)

		Random random = new Random();
		int index = 6;
		int[] lotto = new int[index];

		for (int i = 0; i < index; i++)
			lotto[i] = random.nextInt(45) + 1;

		for (int i = 0; i < index - 1; i++) {
			for (int j = 0; j < index - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < index; i++)
			System.out.printf("%d ", lotto[i]);

	}

}
