package ex06_OOP캡슐화;

public class Exam {

	private int kor;
	private int eng;
	private int math;

	public void print() {
		System.out.printf("kor is %d\n", this.kor);
		System.out.printf("eng is %d\n", this.eng);
		System.out.printf("math is %d\n", this.math);
	}

	public void init(int kor, int eng, int math) { // overload (+내용)
		this.kor = 10;
		this.eng = 20;
		this.math = 30;
	}

	public void init() { // default (+호출)
		this.init(0, 0, 0); // '거쳐가는 것이구나!', '변수값이 0, 즉 초기화처럼'
		this.kor = 10;
		this.eng = 20;
		this.math = 30;
		
	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Exam() { // Exam은 이름이 아니다. (다른 함수이름이랑 같은 색이지만..)
		this(10, 10, 10);
		// or new Exam(10, 10, 10); '원칙은 이거네.'
	}

}
