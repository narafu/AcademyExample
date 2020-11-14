package review._0316ex02;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam();

		// input
		Scanner scan = new Scanner(System.in);
		System.out.print("국어: ");
		exam.setKor(scan.nextInt());
		System.out.print("영어: ");
		exam.setEng(scan.nextInt());
		System.out.print("수어: ");
		exam.setMath(scan.nextInt());

		int total = exam.total();
		float avg = exam.avg();

		// print
		System.out.printf("국어: %d\n", exam.getKor());
		System.out.printf("영어: %d\n", exam.getEng());
		System.out.printf("수학: %d\n", exam.getMath());
		System.out.printf("총점: %d\n", exam.total());
		System.out.printf("평균: %f\n", exam.avg());

	}

}
