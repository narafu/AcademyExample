package ex03_FunctionTopDown;

import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		final int GEN_AUTO = 1;
		final int GEN_MANUAL = 2;
		final int END = 3;
		boolean end = true;

		while (end) {
			int menu = inputMenu();
			System.out.println();

			switch (menu) {
			case GEN_AUTO:
				genAuto(lotto);
				break;
			case GEN_MANUAL:
				genManual(lotto);
				break;
			case END:
				System.out.print("종료!!");
				end = false;
				break;
			default:
				System.out.println("범위를 벗어났습니다.");
			}

			sortLotto(lotto);
			printLotto(lotto);

		}
	}

	public static void sortLotto(int[] lotto) {

		// 크기정렬
		for (int i = 0; i < 6 - 1; i++) {
			for (int j = 0; j < 6 - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}

	}

	public static void printLotto(int[] lotto) {

		for (int i = 0; i < 6; i++)
			System.out.printf("%d ", lotto[i]);
		System.out.println();
	}

	public static void genManual(int[] lotto) {

		Scanner scan = new Scanner(System.in);

		System.out.println("2. 수동 선택");
		System.out.println("원하는 로또 번호를 입력하세요. (범위 1~45) > ");
		
		for (int i = 0; i < 6; i++) {
			// 수동입력 + 범위검사
			do {
				System.out.printf("[%d] : ", i + 1);
				lotto[i] = scan.nextInt();
				if (!(0 < lotto[i] && lotto[i] < 46))
					System.out.println("범위를 벗어났습니다.");
			} while (!(0 < lotto[i] && lotto[i] < 46));

			// 중복검사
			for (int j = 0; j < i; j++)
				if (lotto[i] == lotto[j]) {
					System.out.println("중복되었습니다.");
					i--;
				}
		}

	}

	public static void genAuto(int[] lotto) {

		Random rand = new Random();
		System.out.println("1. 자동 선택");

		// 자동입력 + 중복방지
		for (int i = 0; i < 6; i++) {
			lotto[i] = rand.nextInt(45) + 1;
			for (int j = 0; j < i; j++)
				while (lotto[i] == lotto[j])
					lotto[i] = rand.nextInt(45) + 1;
		}

	}

	public static int inputMenu() {

		System.out.println();
		System.out.println("**로또 만들기**");
		System.out.println("1. 자동 선택");
		System.out.println("2. 수동 선택");
		System.out.println("3. 종료");
		Scanner scan = new Scanner(System.in);

		System.out.print("입력(범위 1~3)> ");
		int menu = scan.nextInt();

		return menu;
	}

}
