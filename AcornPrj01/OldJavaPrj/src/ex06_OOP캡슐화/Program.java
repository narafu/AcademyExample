package ex06_OOP캡슐화;

public class Program {

	public static void main(String[] args) {

		Exam exam = new Exam();

		exam.init();
		exam.print(); // instance method

	}

}

/* 오버로드를 만드는 이유는 메인에서 값을 입력하기 위해서다.
 * 클래스에 가서 값을 입력하면 여러 인자를 입력할 수도 있지만,
 * 메인에서 입력하는 편의성을 위해서이다.*/
