package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int menu;
		int width = 0;
		int height = 0;

		while (true) {
			System.out.println("Q. 바둑판 크기를 선택하세요 > ");
			System.out.println("1. (10 x 10)");
			System.out.println("2. (20 x 20)");
			System.out.println("3. (30 x 30)");
			System.out.print("> ");
			menu = Integer.parseInt(scan.nextLine());

			if ((0 < menu && menu < 4))
				break;

			System.out.println("범위값(1~3)을 입력하세요.");
			System.out.println();

		}
		switch (menu) {
		case 1:
			width = 10;
			height = 10;
			break;
		case 2:
			width = 20;
			height = 20;
			break;
		case 3:
			width = 30;
			height = 30;
			break;
		}

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == 1 && y == 1)
					System.out.print("┌");
				else if (x == 1 && y == height)
					System.out.print("└");
				else if (x == width && y == 1)
					System.out.print("┐");
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

		while (true) {

			System.out.print("\n바둑돌 좌표 (x, y) or Exit(-1) > ");
			ox = Integer.parseInt(scan.next());

			if (ox == -1) {
				System.out.println("> Bye");
				break;
			}

			oy = Integer.parseInt(scan.next());

			if (!(0 < ox && ox <= width)) {
				System.out.println("x값이 바둑판의 범위를 벗어났습니다.");
				if (!(0 < oy && oy <= height))
					System.out.println("y값이 바둑판의 범위를 벗어났습니다.");
				continue;
			}
			if (!(0 < oy && oy <= height)) {
				System.out.println("y값이 바둑판의 범위를 벗어났습니다.");
				continue;
			}

			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)
					if (x == ox && y == oy)
						System.out.print("○");

					else if (x == 1 && y == 1)
						System.out.print("┌");
					else if (x == 1 && y == height)
						System.out.print("└");
					else if (x == width && y == 1)
						System.out.print("┐");
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
		}

		scan.close();
	}

}
