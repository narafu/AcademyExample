package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0229_06 {

	public static void main(String[] args) throws IOException {

		// res/data.txt ���Ͽ��� �ִ밪, �ּҰ� �ֿܼ� ����ϱ�

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int aaa = Integer.parseInt(scan.next());
		int max = aaa;
		int min = aaa;

		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.next());
			if (max < num)
				max = num;
			if (min > num)
				min = num;
		}

		System.out.printf("�ִ밪�� %d\n", max);
		System.out.printf("�ִ밪�� %d\n", min);

		scan.close();
	}
}
