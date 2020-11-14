package review._0318ex02;

public class Review_is_a_»ó¼Ó {

	public static void main(String[] args) {

		MiddleExam exam = new MiddleExam();

		exam.setKor(20);
		exam.setEng(30);
		exam.setMath(40);
		exam.setCom(50);

		System.out.println(exam.total());
		System.out.println(exam.avg());

	}

}
