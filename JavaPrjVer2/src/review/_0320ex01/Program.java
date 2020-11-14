package review._0320ex01;

import java.util.Scanner;

import ex11_OOP_����_interface.Exam;
import ex11_OOP_����_interface.ExamConsole;
import ex11_OOP_����_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new FinalExam();
		ExamConsole console = new ExamConsole(exam);

		console.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				FinalExam fExam = (FinalExam) exam;
				System.out.print("����: ");
				fExam.setScience(scan.nextInt());

			}

			@Override
			public void onPrint(Exam exam) {
				FinalExam fExam = (FinalExam) exam;
				System.out.printf("����: %3d��\n", fExam.getScience());

			}

		});

		console.input();
		console.print();

	}

}
