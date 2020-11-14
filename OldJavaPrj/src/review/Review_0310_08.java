package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0310_08 {

	public static void main(String[] args) throws IOException {

		// ����, ���, �ִ밪, �ּҰ�

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int total = 0;
		int aaa = scan.nextInt();
		int max = aaa;
		int min = aaa;
		int index = 0;
		int count = 0;
		float avg;

		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.next());
			if (++index >= 20) {
				total += num;
				count++;
			}
			if (max < num)
				max = num;
			else if (min > num)
				min = num;

		}

		avg = (float) total / count;
		System.out.printf("20��° ���� ������ ������ %d\n", total);
		System.out.printf("20��° ���� ������ ����� %6.2f\n", avg);
		System.out.printf("�ִ밪�� %d\n", max);
		System.out.printf("�ּҰ��� %d\n", min);

	}

}
