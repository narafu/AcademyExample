package oop재사용;

import java.util.Scanner;

import ex11_OOP_재사용_interface.Exam;
import ex11_OOP_재사용_interface.ExamConsole;
import ex11_OOP_재사용_interface.ExamConsoleListener;

public class Program_Is_a {

	public static void main(String[] args) {

//		AcornExam exam = new AcornExam();
		Exam exam = new AcornExam();
//		Exam exam=new 경원Exam();
		ExamConsole console = new ExamConsole(exam);

		// 약속을 구현해서 넣어야 하는 쪽

		console.setConsoleListener(new ExamConsoleListener() {

			@Override
			public void onInput(Exam exam) {
				Scanner scan = new Scanner(System.in);
				AcornExam acExam = (AcornExam) exam; // 형 변환
				System.out.print("컴퓨터: ");
				acExam.setCom(scan.nextInt());
			}

			@Override
			public void onPrint(Exam exam) {
				AcornExam acExam = (AcornExam) exam; // 형 변환
				System.out.printf("컴퓨터: %3d점\n", acExam.getMath());
			}

		});

		console.input();
		console.print();

	}

}
