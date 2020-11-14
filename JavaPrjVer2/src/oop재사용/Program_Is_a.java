package oop����;

import java.util.Scanner;

import ex11_OOP_����_interface.Exam;
import ex11_OOP_����_interface.ExamConsole;
import ex11_OOP_����_interface.ExamConsoleListener;

public class Program_Is_a {

	public static void main(String[] args) {

//		AcornExam exam = new AcornExam();
		Exam exam = new AcornExam();
//		Exam exam=new ���Exam();
		ExamConsole console = new ExamConsole(exam);

		// ����� �����ؼ� �־�� �ϴ� ��

		console.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				AcornExam acExam = (AcornExam) exam; // �� ��ȯ
				System.out.print("��ǻ��: ");
				acExam.setCom(scan.nextInt());
			}

			@Override
			public void onPrint(Exam exam) {
				AcornExam acExam = (AcornExam) exam; // �� ��ȯ
				System.out.printf("��ǻ��: %3d��\n", acExam.getMath());
			}

		});

		console.input();
		console.print();

	}

}
