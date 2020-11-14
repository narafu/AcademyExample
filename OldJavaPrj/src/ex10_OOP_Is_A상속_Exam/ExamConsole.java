package ex10_OOP_Is_A상속_Exam;

import java.util.Scanner;

public class ExamConsole {

	private Exam exam;

	public ExamConsole() {
		this.exam = new Exam(); // 일체형, has 상속
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
