package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0306_04 {

	public static void main(String[] args) throws IOException {

		// 총점, 평균, 최대값, 최소값

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int total = 0;
		int index = 0;
		int count = 0;
		int a = Integer.parseInt(scan.next());
		int max = a;
		int min = a;

		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.next());
			if (++index >= 10) {
				total += num;
				count++;
			}
			if (max < num)
				max = num;
			if (min > num)
				min = num;
		}

		float avg = (float) total / count;

		System.out.printf("10번째 이후 수들의 총합: %d\n", total);
		System.out.printf("10번째 이후 수들의 평균: %6.2f\n", avg);
		System.out.printf("최대값: %d\n", max);
		System.out.printf("최소값: %d", min);

		scan.close();

	}

}
