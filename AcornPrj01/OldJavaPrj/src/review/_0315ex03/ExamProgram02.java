package review._0315ex03;

import java.util.Scanner;

public class ExamProgram02 {

	public static void main(String[] args) {

		Exam[] exams = new Exam[3];

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			exams[i] = new Exam();
			System.out.printf("%d�г� ����: ", i + 1);
			exams[i].kor = scan.nextInt();
		}

		for (int i = 0; i < 3; i++) {
			System.out.printf("%d�г� ����: %d\n", i + 1, exams[i].kor);
		}
	}
}
