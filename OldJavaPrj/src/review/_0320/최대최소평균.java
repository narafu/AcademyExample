package review._0320;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class �ִ��ּ���� {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int index = 1;
		int count = 0;
		int max = scan.nextInt();
		int min = max;
		int total = 0;

		while (scan.hasNext()) {

			int num = Integer.parseInt(scan.next());
			if (++index >= 20) {
				total += num;
				count++;
			}
			if (max < num)
				max = num;
			if (min > num)
				min = num;
		}

		float avg = (float) total / count;

		System.out.printf("20��°���� ������ ���� %d�Դϴ�.\n", total);
		System.out.printf("20��°���� ������ ����� %6.2f�Դϴ�.\n", avg);
		System.out.printf("�ִ밪�� %d�Դϴ�.\n", max);
		System.out.printf("�ּҰ��� %d�Դϴ�.\n", min);

	}

}
