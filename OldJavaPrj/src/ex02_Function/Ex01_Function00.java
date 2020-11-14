package ex02_Function;

import java.util.Random;

public class Ex01_Function00 {

	public static void main(String[] args) {

		int[] lotto = new int[6];

		// 번호생성
		genLotto(lotto);

		// 번호출력
		printLotto(lotto);

		// 순서정리
		sortLotto(lotto);

		// 번호 출력
		printLotto(lotto);

	}

	public static void genLotto(int[] lotto) {

		Random rand = new Random();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				lotto[i] = rand.nextInt(45) + 1;
				if (lotto[i] == lotto[j])
					lotto[i] = rand.nextInt(45) + 1;
			}
		}

	}

	public static void printLotto(int[] lotto) {

		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);

		System.out.println();
	}

	public static void sortLotto(int[] lotto) {

		for (int j = 0; j < 5; j++)
			for (int i = 0; i < 5 - j; i++)
				if (lotto[i] > lotto[i + 1]) {
					int temp = lotto[i];
					lotto[i] = lotto[i + 1];
					lotto[i + 1] = temp;
				}
	}

}
