package review._0319ex01;

import java.util.Scanner;

import ex11_OOP_재사용_interface.Exam;
import ex11_OOP_재사용_interface.ExamConsole;
import ex11_OOP_재사용_interface.ExamConsoleListener;

public class Program {

	public static void main(String[] args) {

		Exam exam = new KoreaExam();
		ExamConsole console = new ExamConsole(exam);

		console.setConsoleListener(new ExamConsoleListener() {
			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				KoreaExam kExam = (KoreaExam) exam;
				System.out.print("국사: ");
				kExam.setHistory(scan.nextInt());
			}

			@Override
			public void onPrint(Exam exam) {
				KoreaExam kExam = (KoreaExam) exam;
				System.out.printf("국사: %3d점\n", kExam.getHistory());
			}
		});

		console.input();
		console.print();

	}

}
