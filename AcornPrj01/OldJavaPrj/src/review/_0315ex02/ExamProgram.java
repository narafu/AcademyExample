package review._0315ex02;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam(1);
		Exam[] exams = new Exam[exam.getGrade()];
		for (int i = 0; i < exam.getGrade(); i++) {
			exams[i] = new Exam();
		}

		EXIT: while (true) {
			MainMenu menu = menu();
			switch (menu) {

			case INPUT:
				exam.input(exams);
				break;
			case PRINT:
				exam.print(exams);
				break;
			case EXIT:
				System.out.println("�����մϴ�.");
				break EXIT;
			default:
				System.out.println("������ ������ϴ�.");
			}

		}
	}

	private static MainMenu menu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("<���θ޴�>");
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ����");
		MainMenu menu = MainMenu.values()[scan.nextInt() - 1];

		return menu;
	}
}
