package review._0316ex01;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam();

		input(exam);
		print(exam);

	}

	private static void print(Exam exam) {
		System.out.println("<성적출력>");
		System.out.printf("국어: %d\n", exam.getKor());
		System.out.printf("국어: %d\n", exam.getEng());
		System.out.printf("국어: %d\n", exam.getMath());
		System.out.printf("총점: %d\n", exam.total());
		System.out.printf("평균: %6.2f\n", exam.avg());
	}

	private static void input(Exam exam) {
		Scanner scan = new Scanner(System.in);

		System.out.println("<성적입력>");
		System.out.print("국어: ");
		exam.setKor(scan.nextInt());
		System.out.print("영어: ");
		exam.setEng(scan.nextInt());
		System.out.print("수학: ");
		exam.setMath(scan.nextInt());

	}
}
