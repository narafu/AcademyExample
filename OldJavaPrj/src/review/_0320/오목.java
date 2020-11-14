package review._0320;

import java.util.Scanner;

public class ���� {

	public static void main(String[] args) {

		int size = 0;

		final int SMALL_MAP = 1;
		final int LARGE_MAP = 2;
		final int EXIT = 3;

		int menu = menu();

		switch (menu) {
		case SMALL_MAP:
			size = 10;
			break;
		case LARGE_MAP:
			size = 20;
			break;
		case EXIT:
			break;
		default:
			System.out.println("������ ������ϴ�. �ٽ� �Է��ϼ���");
		}
		Board board = new Board(size);
		
		while (true) {
			board.inputBlack(size);
			board.inputWhite(size);
		}
	}

	private static int menu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("< ������� >");
		System.out.println("1. (10 x 10)");
		System.out.println("2. (20 x 20)");
		System.out.println("3. ����");
		System.out.print("> �Է�: ");
		int menu = scan.nextInt();

		return menu;
	}

}
