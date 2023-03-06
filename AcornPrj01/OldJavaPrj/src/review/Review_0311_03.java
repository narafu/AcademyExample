package review;

import java.util.Random;

public class Review_0311_03 {

	public static void main(String[] args) {

		// 로또(입력,정렬,출력) + 중복제거

		Random random = new Random();

		int[] lottos = new int[6];

//		for (int i = 0; i < 6; i++) {
//			lottos[i] = random.nextInt(45) + 1;
//			for (int j = 0; j < i; j++) {
//				while (lottos[i] == lottos[j])
//					lottos[i] = random.nextInt(45) + 1;
//			}
//		}

		for (int i = 0; i < 6; i++) {
			lottos[i] = random.nextInt(45) + 1;
		}

		System.out.print("일차출력: ");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lottos[i]);
		}
		System.out.println();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				while (lottos[i] == lottos[j])
					lottos[i] = random.nextInt(45) + 1;
			}
		}

		System.out.print("중복제거: ");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lottos[i]);
		}
		System.out.println();

		for (int i = 0; i < 6 - 1; i++) {
			for (int j = 0; j < 6 - 1 - i; j++) {
				if (lottos[j] > lottos[j + 1]) {
					int temp = lottos[j];
					lottos[j] = lottos[j + 1];
					lottos[j + 1] = temp;
				}
			}
		}

		System.out.print("최종출력: ");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lottos[i]);
		}

	}

}
