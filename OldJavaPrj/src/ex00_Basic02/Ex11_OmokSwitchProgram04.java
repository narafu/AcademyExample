package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		// ����
		while (true) {
			System.out.println("Q. �ٵ��� ũ�⸦ �����ϼ��� >");
			System.out.println(" 1. (20 x 20)");
			System.out.println(" 2. (40 x 20)");
			System.out.println(" 3. (60 x 30)");
			System.out.print(" > ");

			menu = Integer.parseInt(scan.nextLine());
			System.out.println();
			if (1 <= menu && menu <= 3)
				break;
			else
				System.out.println("������(1~3)�� �Է��ϼ���.\n");
		}

		// ������
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

		// < �ٵ��� >
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)

				// ������
				if (x == 1 && y == 1)
					System.out.print("��");
				else if (x == width && y == 1)
					System.out.print("��");
				else if (x == 1 && y == height)
					System.out.print("��");
				else if (x == width && y == height)
					System.out.print("��");

				// �׵θ�
				else if (y == 1)
					System.out.print("��");
				else if (x == 1)
					System.out.print("��");
				else if (x == width)
					System.out.print("��");
				else if (y == height)
					System.out.print("��");

				// ����
				else
					System.out.print("��");
			System.out.println();
		}

		// �ٵϾ�
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
				System.out.println("x���� ������ ������ϴ�.");
				if (!(0 < oy && oy < height))
					System.out.println("y���� ������ ������ϴ�.");
				continue;

			}
			if (!(0 < oy && oy < height)) {
				System.out.println("y���� ������ ������ϴ�.");
				continue;
			}

			// < �ٵ��� >
			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)

					// �ٵϾ�
					if (x == ox && y == oy)
						System.out.print("��");

					// ������
					else if (x == 1 && y == 1)
						System.out.print("��");
					else if (x == width && y == 1)
						System.out.print("��");
					else if (x == 1 && y == height)
						System.out.print("��");
					else if (x == width && y == height)
						System.out.print("��");

					// �׵θ�
					else if (y == 1)
						System.out.print("��");
					else if (x == 1)
						System.out.print("��");
					else if (x == width)
						System.out.print("��");
					else if (y == height)
						System.out.print("��");

					// ����
					else
						System.out.print("��");
				System.out.println();
			}
		}

		scan.close();
	}
}
