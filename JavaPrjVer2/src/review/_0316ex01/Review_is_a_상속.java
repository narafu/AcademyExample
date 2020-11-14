package review._0316ex01;

public class Review_is_a_»ó¼Ó {

	public static void main(String[] args) {

		AcornExam exam = new AcornExam();

		exam.setKor(10);
		exam.setEng(20);
		exam.setMath(30);
		exam.setCom(40);

		System.out.println(exam.total());
		System.out.println(exam.avg());

	}

}
