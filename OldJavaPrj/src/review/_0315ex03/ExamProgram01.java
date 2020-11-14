package review._0315ex03;

import java.util.Scanner;

public class ExamProgram01 {

	public static void main(String[] args) {

		Exam exam1 = new Exam();
		Exam exam2 = new Exam();
		Exam exam3 = new Exam();

		Scanner scan = new Scanner(System.in);
		System.out.print("1학년 국어: ");
		exam1.kor = scan.nextInt();
		System.out.print("2학년 국어: ");
		exam2.kor = scan.nextInt();
		System.out.print("3학년 국어: ");
		exam3.kor = scan.nextInt();

		System.out.printf("1학년 국어: %d\n", exam1.kor);
		System.out.printf("1학년 국어: %d\n", exam2.kor);
		System.out.printf("1학년 국어: %d\n", exam3.kor);

	}
}
