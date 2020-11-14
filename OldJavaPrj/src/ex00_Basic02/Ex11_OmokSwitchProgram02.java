package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram02 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		System.out.println("\"바둑판 크기를 선택하세요.\"");
		System.out.println("1. (20 x 20)");
		System.out.println("2. (30 x 30)");
		System.out.println("3. (40 x 40)");
		System.out.print("> ");
		menu = Integer.parseInt(scan.nextLine());

		switch (menu) {
		case 1:
			width = 20;
			height = 20;
			break;
		case 2:
			width = 30;
			height = 30;
			break;
		case 3:
			width = 40;
			height = 40;
			break;
		default:
			System.out.println("\n\"선택 값을 벗어났습니다\"");
			System.out.println("\"기본값(10 x 10)으로 설정합니다.\"");
			width = 10;
			height = 10;
		}

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == width && y == 1)
					System.out.print("┐");
				else if (x == 1 && y == height)
					System.out.print("└");
				else if (x == width && y == height)
					System.out.print("┘");
				else if (x == 1)
					System.out.print("├");
				else if (x == width)
					System.out.print("┤");
				else if (y == 1)
					System.out.print("┬");
				else if (y == height)
					System.out.print("┴");
				else
					System.out.print("┼");
			System.out.println();
		}

		int ox = 0;
		int oy = 0;

		do {
			System.out.print("(x, y) > ");
			ox = Integer.parseInt(scan.next());
			oy = Integer.parseInt(scan.next());
			if (!(ox <= width && oy <= height)) {
				System.out.println("\"바둑판 범위를 벗어났습니다.\"");
				System.out.println();
				System.out.println("\"다시 입력하세요.\"");
			}
		} while (!(ox <= width && oy <= height));

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == ox && y == oy)
					System.out.print("○");
				else if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == width && y == 1)
					System.out.print("┐");
				else if (x == 1 && y == height)
					System.out.print("└");
				else if (x == width && y == height)
					System.out.print("┘");
				else if (x == 1)
					System.out.print("├");
				else if (x == width)
					System.out.print("┤");
				else if (y == 1)
					System.out.print("┬");
				else if (y == height)
					System.out.print("┴");
				else
					System.out.print("┼");
			System.out.println();
		}

		scan.close();
	}

}
