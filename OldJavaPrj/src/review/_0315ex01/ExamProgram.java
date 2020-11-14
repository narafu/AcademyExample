package review._0315ex01;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam();

		input(exam);

		print(exam);

	}

	public static void input(Exam exam) {

		Scanner scan = new Scanner(System.in);
		System.out.print("����: ");
		exam.setKor(scan.nextInt());
		System.out.print("����: ");
		exam.setEng(scan.nextInt());
		System.out.print("����: ");
		exam.setMath(scan.nextInt());

	}

	public static void print(Exam exam) {
		System.out.printf("����: %3d\n", exam.getKor());
		System.out.printf("����: %3d\n", exam.getEng());
		System.out.printf("����: %3d\n", exam.getMath());
		System.out.printf("����: %3d\n", exam.total());
		System.out.printf("���: %6.2f\n", exam.avg());

	}
}
