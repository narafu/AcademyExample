package ex09_OOP_Has_A���_Exam;

import java.util.Scanner;

public class ExamConsole {

	// console�� �ٸ� ��ǰ(exam)�� ������! has a ���!
	// console�� exam���κ��� ��ӹ��� ���̴�.

	private Exam exam;

	public ExamConsole() {
		this.exam = new Exam();
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("����: ");
		this.exam.setKor(scan.nextInt());
		System.out.print("����: ");
		this.exam.setEng(scan.nextInt());
		System.out.print("����: ");
		this.exam.setMath(scan.nextInt());
	}

	public void print() {
		int total = this.exam.total();
		float avg = this.exam.avg();
		System.out.printf("����: %3d��\n", this.exam.getKor());
		System.out.printf("����: %3d��\n", this.exam.getEng());
		System.out.printf("����: %3d��\n", this.exam.getMath());
		System.out.printf("����: %3d��\n", total);
		System.out.printf("���: %6.2f��\n", avg);
	}
}
