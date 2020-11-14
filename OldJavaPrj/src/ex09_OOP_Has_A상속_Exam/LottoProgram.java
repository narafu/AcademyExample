package ex09_OOP_Has_A상속_Exam;

import java.util.Scanner;

import ex09_OOP_Has_A상속_Exam.Lotto;

public class LottoProgram {

	public static void main(String[] args) {

		final int AUTO = 1;
		final int MANUAL = 2;
		Lotto lotto = new Lotto();
		int menu = inputMenu();

		switch (menu) {
		case AUTO:
			lotto.genAuto();
			break;
		case MANUAL:
			lotto.genManual();
			break;
		default:
		}

		// print
		int[] nums = lotto.getNums();
		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", nums[i]);
		System.out.println();
	}

	private static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		int menu;
		while (true) {
			System.out.println(" < MENU > ");
			System.out.println(" 1. 자동");
			System.out.println(" 2. 수동");
			System.out.print(" >> 입력 : ");
			menu = scan.nextInt();
			if (1 > menu || menu > 2)
				System.out.println("범위를 벗어났습니다.");
			else
				break;
		}
		return menu;
	}

}