package ex14_Reflection;

// ������, �����ε�, ������ �����ε�
public class Exam {
	private int kor;
	private int eng;
	private int math;

	public Exam() {
		this(10, 10, 10);
	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

//	public void init(int kor, int eng, int math) {
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//	}

//	public void init() {
//		this.init(0, 0, 0);
//	}

	public int total() {
		return this.kor + this.eng + this.math;
	}

	public float avg() {
		return this.total() / 3.0f;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	/*
	 * public void print() { System.out.printf("kor is %d\n", this.kor); }
	 * 
	 * public void input() { Scanner scan = new Scanner(System.in);
	 * System.out.print("kor:"); this.kor = scan.nextInt();
	 * System.out.print("eng:"); this.eng = scan.nextInt();
	 * System.out.print("math:"); this.math = scan.nextInt(); }
	 */

}
