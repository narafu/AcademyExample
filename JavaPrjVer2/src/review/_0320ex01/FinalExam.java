package review._0320ex01;

import ex11_OOP_Àç»ç¿ë_interface.Exam;

public class FinalExam extends Exam {

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
		return total() / 4.0f;
	}

}
