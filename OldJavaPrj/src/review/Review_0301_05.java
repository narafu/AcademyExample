package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0301_05 {

	public static void main(String[] args) throws IOException {

		// res/data.txt 파일에서 20번째 이후 수들의 총합, 평균, 최대값, 최소값 구하기

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

		System.out.printf("20번째 이후 수들의 총합: %d\n", total);
		System.out.printf("20번째 이후 수들의 평균: %.2f\n", avg);
		System.out.printf("최대값: %d\n", max);
		System.out.printf("최소값: %d\n", min);

		scan.close();

	}

}
