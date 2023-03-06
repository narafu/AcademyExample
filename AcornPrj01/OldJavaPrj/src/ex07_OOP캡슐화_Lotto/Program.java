package ex07_OOPĸ��ȭ_Lotto;

import java.util.Scanner;

import ex09_OOP_Has_A���_Exam.Lotto;

public class Program {

	// �������� ���α׷��� -> ��ü���� ���α׷���
	// ��ü�� ã�ƶ� -> '~'�� ���α׷� (~:��ü)

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
			System.out.println("� ������� �߱��Ͻðڽ��ϱ�?");
			System.out.println("1. �ڵ� ");
			System.out.println("2. ���� ");
			System.out.println("�� ��?? >> ");
			menu = scan.nextInt();
			if (1 > menu || menu > 2)
				System.out.println("1~2������ �����ϼ���!!");
			else
				break;
		}
		return menu;
	}

}