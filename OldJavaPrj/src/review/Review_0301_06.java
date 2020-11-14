package review;

import java.util.Random;
import java.util.Scanner;

public class Review_0301_06 {

	public static void main(String[] args) {

		// 로또번호(입력,정렬,출력)

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		int index = 6;
		int[] lotto = new int[index];

		for (int i = 0; i < index; i++)
			lotto[i] = random.nextInt(45) + 1;

		for (int j = 0; j < index - 1; j++) {
			for (int i = 0; i < index - 1 - j; i++) {
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
			}
		}

		for (int i = 0; i < index; i++)
			System.out.printf("%d ", lotto[i]);

		scan.close();

	}

}
