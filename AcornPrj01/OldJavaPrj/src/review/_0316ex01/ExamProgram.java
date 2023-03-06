package review._0316ex01;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam();

		input(exam);
		print(exam);

	}

	private static void print(Exam exam) {
		System.out.println("<�������>");
		System.out.printf("����: %d\n", exam.getKor());
		System.out.printf("����: %d\n", exam.getEng());
		System.out.printf("����: %d\n", exam.getMath());
		System.out.printf("����: %d\n", exam.total());
		System.out.printf("���: %6.2f\n", exam.avg());
	}

	private static void input(Exam exam) {
		Scanner scan = new Scanner(System.in);

		System.out.println("<�����Է�>");
		System.out.print("����: ");
		exam.setKor(scan.nextInt());
		System.out.print("����: ");
		exam.setEng(scan.nextInt());
		System.out.print("����: ");
		exam.setMath(scan.nextInt());

	}
}
