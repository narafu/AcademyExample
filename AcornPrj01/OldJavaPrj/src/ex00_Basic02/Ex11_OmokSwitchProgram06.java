package ex00_Basic02;
import java.util.Random;
import java.util.Scanner;

public class Ex11_OmokSwitchProgram06 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int width = 0;
		int height = 0;
		int menu;

		// ���θ޴�
		System.out.println("Q. �ٵ����� ũ�⸦ �����ϼ���");
		System.out.println("1. (10 x 10)");
		System.out.println("2. (20 x 20)");
		System.out.println("3. (30 x 30)");
		System.out.println("4. ����� ����");

		do {
			System.out.print("\n> �Է� : ");
			menu = Integer.parseInt(scan.nextLine());
			if (!(1 <= menu && menu <= 4))
				System.out.println("! ���� ��(1~4)�� ������ϴ�. �ٽ� �Է��ϼ���.");

		} while (!(1 <= menu && menu <= 4));

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
		default:
			System.out.println("\nQ. ���ϴ� ũ�⸦ �Է��ϼ���.");
			System.out.print("> ���� ����: ");
			width = Integer.parseInt(scan.next());
			System.out.print("> ���� ����: \n");
			height = Integer.parseInt(scan.next());
		}

		// �ٵ���
		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)
				if (x == 1 && y == 1)
					System.out.print("��");
				else if (x == 1 && y == height)
					System.out.print("��");
				else if (x == width && y == 1)
					System.out.print("��");
				else if (x == width && y == height)
					System.out.print("��");

				else if (x == 1)
					System.out.print("��");
				else if (x == width)
					System.out.print("��");
				else if (y == 1)
					System.out.print("��");
				else if (y == height)
					System.out.print("��");

				else
					System.out.print("��");

			System.out.println();
		}

		scan.close();

		// �ٵϵ� + �ٵ���
		while (true) {

			Random random = new Random();

			int ox = random.nextInt(width) + 1;
			int oy = random.nextInt(height) + 1;

			for (int y = 1; y <= height; y++) {
				for (int x = 1; x <= width; x++)
					if (x == ox && y == oy)
						System.out.print("��");

					else if (x == 1 && y == 1)
						System.out.print("��");
					else if (x == 1 && y == height)
						System.out.print("��");
					else if (x == width && y == 1)
						System.out.print("��");
					else if (x == width && y == height)
						System.out.print("��");

					else if (x == 1)
						System.out.print("��");
					else if (x == width)
						System.out.print("��");
					else if (y == 1)
						System.out.print("��");
					else if (y == height)
						System.out.print("��");

					else
						System.out.print("��");
				System.out.println();
			}
		}
	}

}
