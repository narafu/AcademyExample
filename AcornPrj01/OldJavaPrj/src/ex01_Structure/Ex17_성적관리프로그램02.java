package ex01_Structure;

import java.util.Scanner;

public class Ex17_�����������α׷�02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Exam[] exams = new Exam[3];
		Exam exam;
		int kor;
		int eng;
		int math;
		final int INPUT = 1;
		final int PRINT = 2;

		Exit: while (true) {

			// �޴�
			System.out.println(" ** �������� ���α׷� ver 0.1 **\n");
			System.out.println("  1. �����Է�");
			System.out.println("  2. �������");
			System.out.println("  3. ��     ��");
			System.out.print("  �Է� > ");
			int menu = Integer.parseInt(scan.next());
			System.out.println();

			switch (menu) {

			case INPUT:

				// �л��� �����Է�
				for (int i = 0; i < 3; i++) {
					exam = new Exam();
					System.out.printf(" < %d��° �л��� ������ �Է��ϼ��� >\n", i + 1);
					System.out.print(" �����: ");
					kor = Integer.parseInt(scan.next());
					System.out.print(" �����: ");
					eng = Integer.parseInt(scan.next());
					System.out.print(" ���м���: ");
					math = Integer.parseInt(scan.next());

					exam.kor = kor;
					exam.eng = eng;
					exam.math = math;
					exams[i] = exam;
					System.out.println(" �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ");
				}
				System.out.println();
				break;

			case PRINT:
				System.out.println(" <�������>");

				int totalKor = 0;
				int totalEng = 0;
				int totalMath = 0;

				// �л��� �������
				for (int i = 0; i < 3; i++) {
					exam = exams[i];
					kor = exam.kor;
					eng = exam.eng;
					math = exam.math;

					int total = kor + eng + math;
					float avg = total / 3.0f;
					System.out.printf(" %d - ����: %3d, ����: %3d, ����: %3d, ����: %3d, ���: %6.2f\n", i + 1, kor, eng, math,
							total, avg);
					totalKor += kor;
					totalEng += eng;
					totalMath += math;
				}

				// ���� ������
				float avgKor = totalKor / 3.0f;
				float avgEng = totalEng / 3.0f;
				float avgMath = totalMath / 3.0f;

				System.out.printf("\n  ���� ��� - ����: %6.2f, ����: %.2f, ����: %6.2f\n", avgKor, avgEng, avgMath);
				System.out.println(" �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ");
				System.out.println();
				break;

			default:

				// ����
				System.out.println(" > ����Ǿ����ϴ�.");
				break Exit;
			}

		}

	}
}
