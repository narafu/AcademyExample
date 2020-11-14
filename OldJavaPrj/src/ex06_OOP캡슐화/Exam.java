package ex06_OOPĸ��ȭ;

public class Exam {

	private int kor;
	private int eng;
	private int math;

	public void print() {
		System.out.printf("kor is %d\n", this.kor);
		System.out.printf("eng is %d\n", this.eng);
		System.out.printf("math is %d\n", this.math);
	}

	public void init(int kor, int eng, int math) { // overload (+����)
		this.kor = 10;
		this.eng = 20;
		this.math = 30;
	}

	public void init() { // default (+ȣ��)
		this.init(0, 0, 0); // '���İ��� ���̱���!', '�������� 0, �� �ʱ�ȭó��'
		this.kor = 10;
		this.eng = 20;
		this.math = 30;
		
	}

	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public Exam() { // Exam�� �̸��� �ƴϴ�. (�ٸ� �Լ��̸��̶� ���� ��������..)
		this(10, 10, 10);
		// or new Exam(10, 10, 10); '��Ģ�� �̰ų�.'
	}

}
