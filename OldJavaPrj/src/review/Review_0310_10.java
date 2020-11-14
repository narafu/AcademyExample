package review;

public class Review_0310_10 {

	public static void main(String[] args) {

		// √ ±‚»≠

		Exam exam = new Exam();
		exam.kor = 30;

		Exam[] exams = new Exam[3];
		exams[0] = new Exam();
		exams[0].kor = 50;

		System.out.println(exam.kor);
		System.out.println(exams[0].kor);

	}
}
