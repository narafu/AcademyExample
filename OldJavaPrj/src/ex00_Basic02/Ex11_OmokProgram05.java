package ex00_Basic02;
import java.util.Scanner;

public class Ex11_OmokProgram05 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print(" *�������� ���� ���̸� �Է��ϼ��� > ");
		int width = Integer.parseInt(scan.nextLine()) + 1;
		System.out.print(" *�������� ���� ���̸� �Է��ϼ��� > ");
		int height = Integer.parseInt(scan.nextLine()) + 1;
		System.out.print(" *�ٵϵ��� ���� ��ġ > ");
		int ox = Integer.parseInt(scan.nextLine()) + 1;
		System.out.print(" *�ٵϵ��� ���� ��ġ > ");
		int oy = Integer.parseInt(scan.nextLine()) + 1;

		scan.close();

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++)

				// �ٵϵ�
				if (y == oy && x == ox) {
					if (ox == width)
						System.out.print("��");
					else
						System.out.print("�ۦ�");
				}

				// ������
				else if (y == 1 && x == 1)
					System.out.print("����");
				else if (y == 1 && x == width)
					System.out.print("��");
				else if (y == height && x == 1)
					System.out.print("����");
				else if (y == height && x == width)
					System.out.print("��");

				// ������ �ܺ�
				else if (y == 1)
					System.out.print("����");
				else if (x == 1)
					System.out.print("����");
				else if (x == width)
					System.out.print("��");
				else if (y == height)
					System.out.print("����");

				// ������ ����
				else
					System.out.print("����");
			System.out.println();
		}

		System.out.println(" *�۾��Ϸ�");
	}
}
