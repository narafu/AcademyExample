package review._0315ex02;

import java.util.Scanner;

public class Exam {

	private int grade;
	private int kor, eng, math;

	public Exam() {
		this(3);
	}

	public Exam(int grade) {
		this.grade = grade;

	}

	public void print(Exam[] exams) {

		for (int i = 0; i < this.grade; i++) {
			System.out.printf("─%d학년─\n", i + 1);
			System.out.printf("국어: %d\n", exams[i].kor);
			System.out.printf("영어: %d\n", exams[i].eng);
			System.out.printf("수학: %d\n", exams[i].math);
			System.out.println();
		}

	}

	public void input(Exam[] exams) {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < this.grade; i++) {
			System.out.printf("─%d학년─\n", i + 1);
			System.out.print("국어: ");
			exams[i].kor = scan.nextInt();
			System.out.print("영어: ");
			exams[i].eng = scan.nextInt();
			System.out.print("수학: ");
			exams[i].math = scan.nextInt();
			System.out.println();
		}
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
