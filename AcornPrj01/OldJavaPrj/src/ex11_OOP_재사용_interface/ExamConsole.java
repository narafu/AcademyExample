package ex11_OOP_����_interface;

import java.util.Scanner;

public class ExamConsole {

	private Exam exam;

	// ����� ����ϴ� ��
	private ExamConsoleListener consoleListener;

	public void setConsoleListener(ExamConsoleListener consoleListener) {
		this.consoleListener = consoleListener;
	}

	public ExamConsole() { // has ���
		this.exam = new Exam();
	}

	public ExamConsole(Exam exam) { // has ��� (Exam(�θ�)-AcornExam)
		this.exam = exam;
	}
//	public void setExam(Exam exam) {
//		this.exam = exam;
//	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("����: ");
		this.exam.setKor(scan.nextInt());
		System.out.print("����: ");
		this.exam.setEng(scan.nextInt());
		System.out.print("����: ");
		this.exam.setMath(scan.nextInt());

		if (consoleListener != null)
			consoleListener.onInput(this.exam);
	}

	public void print() {
		int total = this.exam.total();
		float avg = this.exam.avg();
		System.out.printf("����: %3d��\n", this.exam.getKor());
		System.out.printf("����: %3d��\n", this.exam.getEng());
		System.out.printf("����: %3d��\n", this.exam.getMath());

		if (consoleListener != null)
			consoleListener.onPrint(this.exam);

		System.out.printf("����: %3d��\n", total);
		System.out.printf("���: %6.2f��\n", avg);
	}
}
