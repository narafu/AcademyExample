package ex01_Structure;

import java.util.Scanner;

public class Ex17_�����������α׷�01 {

	public static void main(String[] args) {

		Exam[] exams = new Exam[3];
		final int INPUT = 1;
		final int PRINT = 2;
		int index = 3;

		Exit: while (true) {

			// �޴�

			int menu = mainMenu();

			switch (menu) {
			case INPUT:

				inputList(exams, index);
				break;

			case PRINT:

				printList(exams, index);
				break;

			default:

				// ����
				System.out.println(" > �����մϴ�.");
				break Exit;
			}
		}

	}

	private static void printList(Exam[] exams, int index) {

		System.out.println(" <�������>");

		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;

		// �л��� �������
		for (int i = 0; i < index; i++) {
			int total = exams[i].kor + exams[i].eng + exams[i].math;
			float avg = total / 3.0f;
			System.out.printf(" %d - ����: %3d\n", i + 1, exams[i].kor);
			System.out.printf(" %d - ����: %3d\n", i + 1, exams[i].eng);
			System.out.printf(" %d - ����: %3d\n", i + 1, exams[i].eng);
			System.out.printf(" %d - ����: %3d\n", i + 1, total);
			System.out.printf(" %d - ���: %6.2f\n", i + 1, avg);
			System.out.println(" �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ");
			totalKor += exams[i].kor;
			totalEng += exams[i].eng;
			totalMath += exams[i].math;
		}

		// ���� ������
		float avgKor = totalKor / 3.0f;
		float avgEng = totalEng / 3.0f;
		float avgMath = totalMath / 3.0f;

		System.out.printf("  ���� ��� - ����: %6.2f\n", avgKor);
		System.out.printf("  ���� ��� - ����: %6.2f\n", avgEng);
		System.out.printf("  ���� ��� - ����: %6.2f\n", avgMath);
		System.out.println(" �������������������������������������������������������������������� ");
		System.out.println();

	}

	private static void inputList(Exam[] exams, int index) {

		Scanner scan = new Scanner(System.in);
		// �л��� �����Է�
		for (int i = 0; i < index; i++) {
			exams[i] = new Exam();
			System.out.printf(" < %d��° �л��� ������ �Է��ϼ��� >\n", i + 1);
			System.out.print(" �����: ");
			exams[i].kor = Integer.parseInt(scan.next());
			System.out.print(" �����: ");
			exams[i].eng = Integer.parseInt(scan.next());
			System.out.print(" ���м���: ");
			exams[i].math = Integer.parseInt(scan.next());
			if (i < index - 1)
				System.out.println(" �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ");
			else
				System.out.println(" �������������������������������������������������������������������� ");
		}

	}

	private static int mainMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" ** �������� ���α׷� ver 0.1 **\n");
		System.out.println("  1. �����Է�");
		System.out.println("  2. �������");
		System.out.println("  3. ��     ��");
		System.out.print("  �Է� > ");
		int menu = Integer.parseInt(scan.next());
		System.out.println();

		return menu;

	}
}
