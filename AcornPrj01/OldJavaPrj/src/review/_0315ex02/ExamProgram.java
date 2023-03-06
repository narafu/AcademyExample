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
				System.out.println("종료합니다.");
				break EXIT;
			default:
				System.out.println("범위를 벗어났습니다.");
			}

		}
	}

	private static MainMenu menu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("<메인메뉴>");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		MainMenu menu = MainMenu.values()[scan.nextInt() - 1];

		return menu;
	}
}
