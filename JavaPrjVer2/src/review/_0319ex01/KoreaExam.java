package review._0319ex01;

import ex11_OOP_Àç»ç¿ë_interface.Exam;

public class KoreaExam extends Exam {

	private int history;

	public int getHistory() {
		return history;
	}

	public void setHistory(int history) {
		this.history = history;
	}

	@Override
	public int total() {
		return super.total() + this.history;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

}
