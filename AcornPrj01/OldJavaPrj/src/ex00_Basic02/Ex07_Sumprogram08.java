package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram08 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

//		res폴더에 있는 data.txt에서 15번째 이후의 평균을 구하세요.

		int count = 0;
		int total15Up = 0;

		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 15)
				total15Up += n;
		}

		float avg15Up = (float) total15Up / (count - 14);

		scan.close();

		System.out.printf("15번째 이후 수의 총합은 %d\n", total15Up);
		System.out.printf("15번째 이후 수의 평균은 %f\n", avg15Up);
	}
}
