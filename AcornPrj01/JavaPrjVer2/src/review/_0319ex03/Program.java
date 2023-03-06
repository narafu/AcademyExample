package review._0319ex03;

import java.util.Scanner;

import ex11_OOP_����_interface.Exam;
import ex11_OOP_����_interface.ExamConsole;
import ex11_OOP_����_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new FinalExam();
		ExamConsole examConsole = new ExamConsole(exam);

		examConsole.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				FinalExam fExam = (FinalExam) exam;
				System.out.print("��ȸ: ");
				fExam.setSociety(scan.nextInt());

			}

			@Override
			public void onPrint(Exam exam) {
				FinalExam fExam = (FinalExam) exam;
				System.out.printf("��ȸ: %3d��\n", fExam.getSociety());

			}

		});

		examConsole.input();
		examConsole.print();

	}

}
