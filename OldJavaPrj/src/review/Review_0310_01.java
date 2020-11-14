package review;

import java.util.Random;

public class Review_0310_01 {

	public static void main(String[] args) {

		// 로또(입력,정렬,출력) + 중복제거

		Random random = new Random();

		int[] lotto = new int[6];

		for (int i = 0; i < 6; i++) {
			lotto[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++)
				while (lotto[i] == lotto[j])
					i--;
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}

			}
		}

		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
		}

	}

}
