package review._0320ex01;

import java.util.Scanner;

import ex11_OOP_재사용_interface.Exam;
import ex11_OOP_재사용_interface.ExamConsole;
import ex11_OOP_재사용_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new FinalExam();
		ExamConsole console = new ExamConsole(exam);

		console.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				FinalExam fExam = (FinalExam) exam;
				System.out.print("과학: ");
				fExam.setScience(scan.nextInt());

			}

			@Override
			public void onPrint(Exam exam) {
				FinalExam fExam = (FinalExam) exam;
				System.out.printf("과학: %3d점\n", fExam.getScience());

			}

		});

		console.input();
		console.print();

	}

}
