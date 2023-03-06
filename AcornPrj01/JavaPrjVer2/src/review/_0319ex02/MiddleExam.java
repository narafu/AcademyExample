package review._0319ex02;

import ex11_OOP_Àç»ç¿ë_interface.Exam;

public class MiddleExam extends Exam {

	private int science;

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	@Override
	public int total() {
		return super.total() + this.science;
	}

	@Override
	public float avg() {
		return this.total() / 4.0f;
	}

}
