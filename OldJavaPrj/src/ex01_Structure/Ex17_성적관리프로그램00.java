package ex01_Structure;

public class Ex17_성적관리프로그램00 {

	public static void main(String[] args) {

//		시험성적(10) - 국어, 영어, 수학

		Exam[] exams = new Exam[10];

		Exam exam1 = new Exam();
		exam1.kor = 40;
		exams[0] = exam1;
			exams[0] = new Exam();
			exams[0].kor = 40;

		Exam exam2 = new Exam();
		exam2.kor = 20;
		exams[1] = exam2;

		Exam exam3 = new Exam();
		exam3.kor = 30;
		exams[2] = exam3;

		System.out.printf("kor : %d\n", exam1.kor);
		System.out.printf("kor : %d\n", exam2.kor);
		System.out.printf("kor : %d\n", exam3.kor);

		System.out.printf("kor : %d\n", exams[0].kor);
		System.out.printf("kor : %d\n", exams[1].kor);
		System.out.printf("kor : %d\n", exams[2].kor);

		for (int i = 0; i < 3; i++) {
			System.out.printf("kor : %d\n", exams[i].kor);
		}

//		학생정보(5) - 이름, 학년, 성별
		Student[] students = new Student[5];

//		강의실(3) - 이름, 층, 호수
		ClassRoom[] rooms = new ClassRoom[3];

	}
}
