package review._0319ex01;

import java.util.Scanner;

import ex11_OOP_����_interface.Exam;
import ex11_OOP_����_interface.ExamConsole;
import ex11_OOP_����_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new KoreaExam();
		ExamConsole console = new ExamConsole(exam);

		console.setConsoleListener(new ExamConsoleListener() {
			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				KoreaExam kExam = (KoreaExam) exam;
				System.out.print("����: ");
				kExam.setHistory(scan.nextInt());
			}

			@Override
			public void onPrint(Exam exam) {
				KoreaExam kExam = (KoreaExam) exam;
				System.out.printf("����: %3d��\n", kExam.getHistory());
			}
		});

		console.input();
		console.print();

	}

}
