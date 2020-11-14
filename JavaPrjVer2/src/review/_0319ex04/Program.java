package review._0319ex04;

import java.util.Scanner;

import ex11_OOP_재사용_interface.Exam;
import ex11_OOP_재사용_interface.ExamConsole;
import ex11_OOP_재사용_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new MiddleExam();
		ExamConsole console = new ExamConsole(exam);

		console.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				MiddleExam mExam = (MiddleExam) exam;
				System.out.print("과학: ");
				mExam.setScience(scan.nextInt());
				System.out.print("역사: ");
				mExam.setHistory(scan.nextInt());

			}

			@Override
			public void onPrint(Exam exam) {
				MiddleExam mExam = (MiddleExam) exam;
				System.out.printf("과학: %3d점\n", mExam.getScience());
				System.out.printf("역사: %3d점\n", mExam.getHistory());
			}

		});

		console.input();
		console.print();

	}

}
