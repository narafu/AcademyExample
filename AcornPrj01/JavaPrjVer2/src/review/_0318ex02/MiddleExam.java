package review._0318ex02;

import ex10_OOP_Is_A»ó¼Ó_Exam.Exam;

public class MiddleExam extends Exam {

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
