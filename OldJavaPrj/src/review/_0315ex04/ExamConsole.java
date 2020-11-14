package review._0315ex04;

import java.util.Scanner;

public class ExamConsole {

	ExamList list;

	public ExamConsole() {
		list = new ExamList();
	}

	public void input() {

		Scanner scan = new Scanner(System.in);
		list.exams[list.getCount()] = new Exam();

		System.out.printf("─%d학년─\n", list.getCount() + 1);
		System.out.printf("국어%d: ", list.getCount() + 1);
		list.exams[list.getCount()].setKor(scan.nextInt());
		System.out.printf("영어%d: ", list.getCount() + 1);
		list.exams[list.getCount()].setEng(scan.nextInt());
		System.out.printf("수학%d: ", list.getCount() + 1);
		list.exams[list.getCount()].setMath(scan.nextInt());
		System.out.println();

		list.add();

	}

	public void print() {
		

		for (int i = 0; i < list.getCount(); i++) {
			System.out.printf("─%d학년─\n", i + 1);
			System.out.printf("국어%d: %d\n", i + 1, list.exams[i].getKor());
			System.out.printf("영어%d: %d\n", i + 1, list.exams[i].getEng());
			System.out.printf("수학%d: %d\n", i + 1, list.exams[i].getMath());
//			System.out.printf("총점: %d\n", list.total(list.getCount()));
//			System.out.printf("평균: %6.2f\n", list.avg(list.getCount()));
			System.out.println();
		}
	}

}
