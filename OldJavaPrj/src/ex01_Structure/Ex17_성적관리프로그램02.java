package ex01_Structure;

import java.util.Scanner;

public class Ex17_성적관리프로그램02 {

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

			// 메뉴
			System.out.println(" ** 성적관리 프로그램 ver 0.1 **\n");
			System.out.println("  1. 성적입력");
			System.out.println("  2. 성적출력");
			System.out.println("  3. 종     료");
			System.out.print("  입력 > ");
			int menu = Integer.parseInt(scan.next());
			System.out.println();

			switch (menu) {

			case INPUT:

				// 학생별 성적입력
				for (int i = 0; i < 3; i++) {
					exam = new Exam();
					System.out.printf(" < %d번째 학생의 성적을 입력하세요 >\n", i + 1);
					System.out.print(" 국어성적: ");
					kor = Integer.parseInt(scan.next());
					System.out.print(" 영어성적: ");
					eng = Integer.parseInt(scan.next());
					System.out.print(" 수학성적: ");
					math = Integer.parseInt(scan.next());

					exam.kor = kor;
					exam.eng = eng;
					exam.math = math;
					exams[i] = exam;
					System.out.println(" ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
				}
				System.out.println();
				break;

			case PRINT:
				System.out.println(" <성적출력>");

				int totalKor = 0;
				int totalEng = 0;
				int totalMath = 0;

				// 학생별 성적출력
				for (int i = 0; i < 3; i++) {
					exam = exams[i];
					kor = exam.kor;
					eng = exam.eng;
					math = exam.math;

					int total = kor + eng + math;
					float avg = total / 3.0f;
					System.out.printf(" %d - 국어: %3d, 영어: %3d, 수학: %3d, 총점: %3d, 평균: %6.2f\n", i + 1, kor, eng, math,
							total, avg);
					totalKor += kor;
					totalEng += eng;
					totalMath += math;
				}

				// 과목별 평균출력
				float avgKor = totalKor / 3.0f;
				float avgEng = totalEng / 3.0f;
				float avgMath = totalMath / 3.0f;

				System.out.printf("\n  과목별 평균 - 국어: %6.2f, 영어: %.2f, 수학: %6.2f\n", avgKor, avgEng, avgMath);
				System.out.println(" ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ─ ");
				System.out.println();
				break;

			default:

				// 종료
				System.out.println(" > 종료되었습니다.");
				break Exit;
			}

		}

	}
}
