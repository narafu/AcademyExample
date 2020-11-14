package review._0316ex01;

import ex10_OOP_Is_A»ó¼Ó_Exam.Exam;

public class AcornExam extends Exam {

	private int com;

	@Override
	public int total() {
		return super.total() + this.com;
	}

	@Override
	public float avg() {
		return this.total() / 4.0f;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

}
