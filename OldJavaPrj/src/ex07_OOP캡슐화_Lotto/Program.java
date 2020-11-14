package ex07_OOP캡슐화_Lotto;

import java.util.Scanner;

import ex09_OOP_Has_A상속_Exam.Lotto;

public class Program {

	// 구조적인 프로그래밍 -> 객체지향 프로그래밍
	// 개체를 찾아라 -> '~'의 프로그램 (~:개체)

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

		lotto.print();
	}

	private static int inputMenu() {

		Scanner scan = new Scanner(System.in);
		int menu;
		while (true) {
			System.out.println("어떤 방식으로 발권하시겠습니까?");
			System.out.println("1. 자동 ");
			System.out.println("2. 수동 ");
			System.out.println("몇 번?? >> ");
			menu = scan.nextInt();
			if (1 > menu || menu > 2)
				System.out.println("1~2까지만 선택하세요!!");
			else
				break;
		}
		return menu;
	}

}