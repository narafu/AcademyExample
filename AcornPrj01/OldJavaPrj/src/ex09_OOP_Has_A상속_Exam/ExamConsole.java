package ex09_OOP_Has_A상속_Exam;

import java.util.Scanner;

public class ExamConsole {

	// console이 다른 부품(exam)을 가졌다! has a 상속!
	// console이 exam으로부터 상속받은 것이다.

	private Exam exam;

	public ExamConsole() {
		this.exam = new Exam();
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("국어: ");
		this.exam.setKor(scan.nextInt());
		System.out.print("영어: ");
		this.exam.setEng(scan.nextInt());
		System.out.print("수학: ");
		this.exam.setMath(scan.nextInt());
	}

	public void print() {
		int total = this.exam.total();
		float avg = this.exam.avg();
		System.out.printf("국어: %3d점\n", this.exam.getKor());
		System.out.printf("영어: %3d점\n", this.exam.getEng());
		System.out.printf("수학: %3d점\n", this.exam.getMath());
		System.out.printf("총점: %3d점\n", total);
		System.out.printf("평균: %6.2f점\n", avg);
	}
}
