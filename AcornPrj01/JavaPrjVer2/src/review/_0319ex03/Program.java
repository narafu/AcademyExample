package review._0319ex03;

import java.util.Scanner;

import ex11_OOP_재사용_interface.Exam;
import ex11_OOP_재사용_interface.ExamConsole;
import ex11_OOP_재사용_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new FinalExam();
		ExamConsole examConsole = new ExamConsole(exam);

		examConsole.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				FinalExam fExam = (FinalExam) exam;
				System.out.print("사회: ");
				fExam.setSociety(scan.nextInt());

			}

			@Override
			public void onPrint(Exam exam) {
				FinalExam fExam = (FinalExam) exam;
				System.out.printf("사회: %3d점\n", fExam.getSociety());

			}

		});

		examConsole.input();
		examConsole.print();

	}

}
