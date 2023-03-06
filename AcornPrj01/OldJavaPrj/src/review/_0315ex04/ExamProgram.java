package review._0315ex04;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {

		ExamConsole console = new ExamConsole();

		EXIT: while (true) {

			MainMenu menu = menu();
			switch (menu) {

			case INPUT:
				console.input();
				break;
			case PRINT:
				console.print();
				break;
			case EXIT:
				System.out.println("종료합니다.");
				break EXIT;
			}
		}
	}

	private static MainMenu menu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("<메인메뉴>");
		System.out.println("1. 성적입력");
		System.out.println("2. 성적출력");
		System.out.println("3. 종료");
		MainMenu menu = MainMenu.values()[scan.nextInt() - 1];

		return menu;
	}
}
