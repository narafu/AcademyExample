package review._0317ex01;

import ex10_OOP_Is_A»ó¼Ó_Exam.Exam;

public class FinalExam extends Exam {

	private int com;

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return super.total() + this.com;
	}

	@Override
	public float avg() {
		// TODO Auto-generated method stub
		return this.total() / 4.0f;
	}

}
