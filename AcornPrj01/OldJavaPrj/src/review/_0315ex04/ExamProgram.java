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
				System.out.println("�����մϴ�.");
				break EXIT;
			}
		}
	}

	private static MainMenu menu() {

		Scanner scan = new Scanner(System.in);

		System.out.println("<���θ޴�>");
		System.out.println("1. �����Է�");
		System.out.println("2. �������");
		System.out.println("3. ����");
		MainMenu menu = MainMenu.values()[scan.nextInt() - 1];

		return menu;
	}
}
