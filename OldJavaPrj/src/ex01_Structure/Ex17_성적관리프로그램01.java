package ex01_Structure;

import java.util.Scanner;

public class Ex17_성적관리프로그램01 {

	public static void main(String[] args) {

		Exam[] exams = new Exam[3];
		final int INPUT = 1;
		final int PRINT = 2;
		int index = 3;

		Exit: while (true) {

			// 메뉴

			int menu = mainMenu();

			switch (menu) {
			case INPUT:

				inputList(exams, index);
				break;

			case PRINT:

				printList(exams, index);
				break;

			default:

				// 종료
				System.out.println(" > 종료합니다.");
				break Exit;
			}
		}

	}

	private static void printList(Exam[] exams, int index) {

		System.out.println(" <성적출력>");

		int totalKor = 0;
		int totalEng = 0;
		int totalMath = 0;

		// 학생별 성적출력
		for (int i = 0; i < index; i++) {
			int total = exams[i].kor + exams[i].eng + exams[i].math;
			float avg = total / 3.0f;
			System.out.printf(" %d - 국어: %3d\n", i + 1, exams[i].kor);
			System.out.printf(" %d - 영어: %3d\n", i + 1, exams[i].eng);
			System.out.printf(" %d - 수학: %3d\n", i + 1, exams[i].eng);
			System.out.printf(" %d - 총점: %3d\n", i + 1, total);
			System.out.printf(" %d - 평균: %6.2f\n", i + 1, avg);
			System.out.println(" ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
			totalKor += exams[i].kor;
			totalEng += exams[i].eng;
			totalMath += exams[i].math;
		}

		// 과목별 평균출력
		float avgKor = totalKor / 3.0f;
		float avgEng = totalEng / 3.0f;
		float avgMath = totalMath / 3.0f;

		System.out.printf("  과목별 평균 - 국어: %6.2f\n", avgKor);
		System.out.printf("  과목별 평균 - 영어: %6.2f\n", avgEng);
		System.out.printf("  과목별 평균 - 수학: %6.2f\n", avgMath);
		System.out.println(" ────────────────────────────────── ");
		System.out.println();

	}

	private static void inputList(Exam[] exams, int index) {

		Scanner scan = new Scanner(System.in);
		// 학생별 성적입력
		for (int i = 0; i < index; i++) {
			exams[i] = new Exam();
			System.out.printf(" < %d번째 학생의 성적을 입력하세요 >\n", i + 1);
			System.out.print(" 국어성적: ");
			exams[i].kor = Integer.parseInt(scan.next());
			System.out.print(" 영어성적: ");
			exams[i].eng = Integer.parseInt(scan.next());
			System.out.print(" 수학성적: ");
			exams[i].math = Integer.parseInt(scan.next());
			if (i < index - 1)
				System.out.println(" ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
			else
				System.out.println(" ────────────────────────────────── ");
		}

	}

	private static int mainMenu() {

		Scanner scan = new Scanner(System.in);

		System.out.println(" ** 성적관리 프로그램 ver 0.1 **\n");
		System.out.println("  1. 성적입력");
		System.out.println("  2. 성적출력");
		System.out.println("  3. 종     료");
		System.out.print("  입력 > ");
		int menu = Integer.parseInt(scan.next());
		System.out.println();

		return menu;

	}
}
