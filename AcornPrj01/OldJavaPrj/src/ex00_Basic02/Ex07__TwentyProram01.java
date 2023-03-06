package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07__TwentyProram01 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		String num;
		int n = 0;
		int total20up = 0;
		int count = 0;
		float avg20up;

		while (scan.hasNext()) {

			num = scan.next();
			n = Integer.parseInt(num);
			count++;

			if (count >= 20)
				total20up += n;

		}

		avg20up = (float) total20up / (count - 19);

		scan.close();
		fis.close();

		System.out.printf("20번째 이상의 값들의 합은 %d\n", total20up);
		System.out.printf("20번째 이상의 값들의 평균은 %f\n", avg20up);

	}

}
