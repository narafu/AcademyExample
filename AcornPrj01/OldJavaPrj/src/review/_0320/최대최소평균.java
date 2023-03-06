package review._0320;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class 최대최소평균 {

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

		System.out.printf("20번째부터 수들의 합은 %d입니다.\n", total);
		System.out.printf("20번째부터 수들의 평균은 %6.2f입니다.\n", avg);
		System.out.printf("최대값은 %d입니다.\n", max);
		System.out.printf("최소값은 %d입니다.\n", min);

	}

}
