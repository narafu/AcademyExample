package oop재사용;

import ex11_OOP_재사용_interface.Exam;

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
