package ex11_OOP_����_interface;

public interface ExamConsoleListener {

	// �������̽��� �����ؾ��� ��ӿ� ���� �Լ��� ����س��� ���̴�.
	// so, �ʵ尡 �ʿ� ����.
	// so, ���������ڵ� �ʿ� ����.
	// so, �����ؾ��� ��ϸ� ����ϹǷ�, �Լ� �ڿ� �߰�ȣ�� ���� �ʴ´�.
	// �߰�ȣ�� ���ٴ� ���� �Լ��� �����Ѵٴ� ���̴ϱ�.

	void onInput(Exam exam);

	void onPrint(Exam exam);

}
