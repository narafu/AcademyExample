package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0228_06b {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int index = 0;
		int count = 0;
		int total = 0;

		while (scan.hasNext()) {
			int num = Integer.parseInt(scan.next());
			if (++index >= 15) {
				total += num;
				count++;
			}

		}

		float avg = (float) total / count;

		System.out.printf("15번째 이후 수둘의 총합: %d\n", total);
		System.out.printf("15번째 이후 수둘의 평균: %.2f\n", avg);
		
		scan.close();
		fis.close();

	}

}
