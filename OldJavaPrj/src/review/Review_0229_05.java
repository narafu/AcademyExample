package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0229_05 {

	public static void main(String[] args) throws IOException {

		// res/data.txt 파일에서 20번째 이후 수들의 총합, 평균 콘솔에 출력하기

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int total = 0;
		int index = 0;
		int count = 0;

		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.next());
			if (++index >= 20) {
				total += num;
				count++;
			}

		}

		float avg = (float) total / count;

		System.out.printf("20번째 이후 수들의 총합: %d\n", total);
		System.out.printf("20번째 이후 수들의 평균: %.2f\n", avg);

		scan.close();

	}
}
