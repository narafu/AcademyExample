package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0301_05 {

	public static void main(String[] args) throws IOException {

		// res/data.txt ���Ͽ��� 20��° ���� ������ ����, ���, �ִ밪, �ּҰ� ���ϱ�

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		float avg;
		int total = 0;
		int aaa = Integer.parseInt(scan.next());
		int max = aaa;
		int min = aaa;
		int index = 1;
		int count = 0;

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

		avg = (float) total / count;

		System.out.printf("20��° ���� ������ ����: %d\n", total);
		System.out.printf("20��° ���� ������ ���: %.2f\n", avg);
		System.out.printf("�ִ밪: %d\n", max);
		System.out.printf("�ּҰ�: %d\n", min);

		scan.close();

	}

}
