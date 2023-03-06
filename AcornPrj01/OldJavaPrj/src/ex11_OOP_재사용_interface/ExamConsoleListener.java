package ex11_OOP_재사용_interface;

public interface ExamConsoleListener {

	// 인터페이스는 구현해야할 약속에 대한 함수를 목록해놓은 것이다.
	// so, 필드가 필요 없다.
	// so, 접근제어자도 필요 없다.
	// so, 구현해야할 목록만 명시하므로, 함수 뒤에 중괄호를 쓰지 않는다.
	// 중괄호를 쓴다는 것은 함수를 구현한다는 것이니까.

	void onInput(Exam exam);

	void onPrint(Exam exam);

}
