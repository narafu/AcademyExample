package review;

public class Review_0311_01 {

	public static void main(String[] args) {

		// 초기화 - 입력 - 출력

		Exam exam = new Exam();

		Exam[] exams = new Exam[3];
		exams[0] = new Exam();

		exam.kor = 80;
		exams[0].kor = 100;

		System.out.print("exam.kor: ");
		System.out.println(exam.kor);
		System.out.print("exams[0].kor: ");
		System.out.println(exams[0].kor);

		System.out.print("exam.eng: ");
		System.out.println(exam.eng); // Exam[] exams = new Exam[3];
		System.out.print("exams[0].eng: ");
		System.out.println(exams[0].eng); // exams[0] = new Exam();

		System.out.print("exams[1].kor: ");
		System.out.println(exams[1].kor);

	}
}
