package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0307_04 {

	public static void main(String[] args) throws IOException {

		// 총점, 평균, 최대값, 최소값

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int total = 0;
		int aaa = scan.nextInt();
		int max = aaa;
		int min = aaa;
		int temp = 0;
		int count = 0;

		while (scan.hasNext()) {

			int num = Integer.parseInt(scan.next());

			if (++temp >= 20) {
				total += num;
				count++;
			}

			if (max < num)
				max = num;

			if (min > num)
				min = num;

		}

		float avg = (float) total / count;

		System.out.printf("20번째 이후 수둘의 총합은 %d\n", total);
		System.out.printf("20번째 이후 수둘의 평균은 %6.2f\n", avg);
		System.out.printf("최대값은 %d\n", max);
		System.out.printf("최소값은 %d", min);

		scan.close();

	}

}
