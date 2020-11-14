package review._0319ex03;

import ex11_OOP_Àç»ç¿ë_interface.Exam;

public class FinalExam extends Exam {

	private int society;

	public int getSociety() {
		return society;
	}

	public void setSociety(int society) {
		this.society = society;
	}

	@Override
	public int total() {
		return super.total() + this.society;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

}
