package review._0316ex03;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		Exam exam = new Exam();

		// input
		Scanner scan = new Scanner(System.in);
		System.out.print("����: ");
		exam.setKor(scan.nextInt());
		System.out.print("����: ");
		exam.setEng(scan.nextInt());
		System.out.print("����: ");
		exam.setMath(scan.nextInt());

		// print
		System.out.printf("����: %d\n", exam.getKor());
		System.out.printf("����: %d\n", exam.getEng());
		System.out.printf("����: %d\n", exam.getMath());
		System.out.printf("����: %d\n", exam.total());
		System.out.printf("���: %f\n", exam.avg());

	}

}
