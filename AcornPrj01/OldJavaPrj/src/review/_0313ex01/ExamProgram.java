package review._0313ex01;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam(10, 10, 10);

		// input
		Scanner scan = new Scanner(System.in);
		System.out.print("����: ");
		exam.setKor(scan.nextInt());
		System.out.print("����: ");
		exam.setEng(scan.nextInt());
		System.out.print("����: ");
		exam.setMath(scan.nextInt());

		int total = exam.total();
		float avg = exam.avg();

		// print
		System.out.printf("����: %d\n", exam.getKor());
		System.out.printf("����: %d\n", exam.getEng());
		System.out.printf("����: %d\n", exam.getMath());
		System.out.printf("����: %d\n", total);
		System.out.printf("����: %f\n", avg);

	}

}
