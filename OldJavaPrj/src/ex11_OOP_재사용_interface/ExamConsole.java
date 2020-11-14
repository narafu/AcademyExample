package ex11_OOP_재사용_interface;

import java.util.Scanner;

public class ExamConsole {

	private Exam exam;

	// 약속을 사용하는 쪽
	private ExamConsoleListener consoleListener;

	public void setConsoleListener(ExamConsoleListener consoleListener) {
		this.consoleListener = consoleListener;
	}

	public ExamConsole() { // has 상속
		this.exam = new Exam();
	}

	public ExamConsole(Exam exam) { // has 상속 (Exam(부모)-AcornExam)
		this.exam = exam;
	}
//	public void setExam(Exam exam) {
//		this.exam = exam;
//	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("국어: ");
		this.exam.setKor(scan.nextInt());
		System.out.print("영어: ");
		this.exam.setEng(scan.nextInt());
		System.out.print("수학: ");
		this.exam.setMath(scan.nextInt());

		if (consoleListener != null)
			consoleListener.onInput(this.exam);
	}

	public void print() {
		int total = this.exam.total();
		float avg = this.exam.avg();
		System.out.printf("국어: %3d점\n", this.exam.getKor());
		System.out.printf("영어: %3d점\n", this.exam.getEng());
		System.out.printf("수학: %3d점\n", this.exam.getMath());

		if (consoleListener != null)
			consoleListener.onPrint(this.exam);

		System.out.printf("총점: %3d점\n", total);
		System.out.printf("평균: %6.2f점\n", avg);
	}
}
