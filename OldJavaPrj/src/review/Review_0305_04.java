package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0305_04 {

	public static void main(String[] args) throws IOException {

		// ����, ���, �ִ밪, �ּҰ�

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int aaa = Integer.parseInt(scan.next());
		int max = aaa;
		int min = aaa;
		int total = 0;
		int index = 0;
		int count = 0;

		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.next());
			if (max < num)
				max = num;
			if (min > num)
				min = num;
			if (++index >= 30) {
				total += num;
				count++;
			}
		}

		float avg = (float) total / count;

		System.out.printf("30��° ���� ������ ����: %d\n", total);
		System.out.printf("30��° ���� ������ ���: %6.2f\n", avg);
		System.out.printf("�ִ밪: %d\n", max);
		System.out.printf("�ּҰ�: %d\n", min);

		scan.close();

	}

}
