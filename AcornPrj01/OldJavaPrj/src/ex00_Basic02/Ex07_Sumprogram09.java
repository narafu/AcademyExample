package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram09 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");

		Scanner scan = new Scanner(fis);

		int count = 0;
		int total30Up = 0;
		float avg30Up = 0;

		while (scan.hasNext()) {

			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;

			if (count >= 30)
				total30Up += n;

		}

		avg30Up = (float) total30Up / count - 29;

		scan.close();

		System.out.printf("30번째 이후 수들의 총합: %d\n", total30Up);
		System.out.printf("30번째 이후 수들의 평균: %f\n", avg30Up);

	}
}

// 1. res폴더에 data.txt에서 30번째 이후의 총합을 구하시오.
// 2. res폴더에 data.txt에서 30번째 이후의 평균을 구하시오.
