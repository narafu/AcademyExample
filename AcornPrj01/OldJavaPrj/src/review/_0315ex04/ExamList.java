package review._0315ex04;

public class ExamList {

	Exam[] exams = new Exam[1];
	private int count;

	public void add() {
		count++;
		if (exams.length == count) {
			Exam[] temp = new Exam[exams.length + 1];
			for (int i = 0; i < count; i++) {
				temp[i] = exams[i];
			}
			exams = temp;
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
