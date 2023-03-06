package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07__TwentyProram02 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int total = 0, count = 0, index = 0;
		float avg;

		while (scan.hasNext()) {
			int n;
			n = Integer.parseInt(scan.next());

			if (++index >= 20) {
				total += n;
				count++;
			}

		}

		scan.close();
		fis.close();

		avg = (float) total / count;

		System.out.printf("20번째 이상의 값들의 합은 %d\n", total);
		System.out.printf("20번째 이상의 값들의 평균은 %f\n", avg);

	}

}
