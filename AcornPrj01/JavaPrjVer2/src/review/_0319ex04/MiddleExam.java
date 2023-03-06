package review._0319ex04;

import ex11_OOP_Àç»ç¿ë_interface.Exam;

public class MiddleExam extends Exam {

	private int science, history;

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getHistory() {
		return history;
	}

	public void setHistory(int history) {
		this.history = history;
	}

	@Override
	public int total() {
		return super.total() + this.science + this.history;
	}

	@Override
	public float avg() {
		return total() / 5.0f;
	}
}
