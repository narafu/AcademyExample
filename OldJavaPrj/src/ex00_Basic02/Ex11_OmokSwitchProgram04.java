package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		// 메인
		while (true) {
			System.out.println("Q. 바둑판 크기를 선택하세요 >");
			System.out.println(" 1. (20 x 20)");
			System.out.println(" 2. (40 x 20)");
			System.out.println(" 3. (60 x 30)");
			System.out.print(" > ");

			menu = Integer.parseInt(scan.nextLine());
			System.out.println();
			if (1 <= menu && menu <= 3)
				break;
			else
				System.out.println("범위값(1~3)을 입력하세요.\n");
		}

		// 선택지
		switch (menu) {
		case 1:
			width = 20;
			height = 20;
			break;
		case 2:
			width = 40;
			height = 20;
			break;
		case 3:
			width = 60;
			height = 30;
			break;
		default:
			System.out.println("?");
		}

		// < 바둑판 >
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)

				// 꼭지점
				if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == width && y == 1)
					System.out.print("┐");
				else if (x == 1 && y == height)
					System.out.print("└");
				else if (x == width && y == height)
					System.out.print("┘");

				// 테두리
				else if (y == 1)
					System.out.print("┬");
				else if (x == 1)
					System.out.print("├");
				else if (x == width)
					System.out.print("┤");
				else if (y == height)
					System.out.print("┴");

				// 내부
				else
					System.out.print("┼");
			System.out.println();
		}

		// 바둑알
		int ox = 0;
		int oy = 0;

		while (true) {

			System.out.print("\n(x, y) or exit(-1) > ");
			ox = Integer.parseInt(scan.next());

			if (ox == -1) {
				System.out.println("\n> Bye");
				break;
			}

			oy = Integer.parseInt(scan.next());

			if (!(0 < ox && ox < width)) {
				System.out.println("x값이 범위를 벗어났습니다.");
				if (!(0 < oy && oy < height))
					System.out.println("y값이 범위를 벗어났습니다.");
				continue;

			}
			if (!(0 < oy && oy < height)) {
				System.out.println("y값이 범위를 벗어났습니다.");
				continue;
			}

			// < 바둑판 >
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)

					// 바둑알
					if (x == ox && y == oy)
						System.out.print("○");

					// 꼭지점
					else if (x == 1 && y == 1)
						System.out.print("┌");
					else if (x == width && y == 1)
						System.out.print("┐");
					else if (x == 1 && y == height)
						System.out.print("└");
					else if (x == width && y == height)
						System.out.print("┘");

					// 테두리
					else if (y == 1)
						System.out.print("┬");
					else if (x == 1)
						System.out.print("├");
					else if (x == width)
						System.out.print("┤");
					else if (y == height)
						System.out.print("┴");

					// 내부
					else
						System.out.print("┼");
				System.out.println();
			}
		}

		scan.close();
	}
}
