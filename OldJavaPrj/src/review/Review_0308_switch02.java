package review;

import java.util.Random;
import java.util.Scanner;

public class Review_0308_switch02 {

	public static void main(String[] args) {

		// switch

		Scanner scan = new Scanner(System.in);
		Random random = new Random();

		int index = 6;

		Exit: while (true) {

			System.out.println("< 랜덤 프로그램 >");
			System.out.println("1. 5개");
			System.out.println("2. 10개");
			System.out.println("?. 종료\n");
			System.out.print("입력 > ");
			int menu = scan.nextInt();

			switch (menu) {

			case 1:
				index = 5;
				break;
			case 2:
				index = 10;
				break;
			default:
				System.out.println("\n종료되었습니다.");
				break Exit;
			}

			System.out.println();
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
			System.out.println();
			System.out.println();
		}
	}
}
