package review._0319ex02;

import java.util.Scanner;

import ex11_OOP_����_interface.Exam;
import ex11_OOP_����_interface.ExamConsole;
import ex11_OOP_����_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new MiddleExam();
		ExamConsole console = new ExamConsole(exam);

		console.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				MiddleExam mExam = (MiddleExam) exam;
				System.out.print("����: ");
				mExam.setScience(scan.nextInt());

			}

			@Override
			public void onPrint(Exam exam) {
				MiddleExam mExam = (MiddleExam) exam;
				System.out.printf("����: %3d��\n", mExam.getScience());

			}

		});

		console.input();
		console.print();

	}

}
