package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram13 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int total15Up = 0;
		int count = 0;

		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count > 16)
				total15Up += n;
		}

		float avg15Up = (float) total15Up / count - 14;
		scan.close();

		System.out.printf("15번째 이후 총합: %d\n", total15Up);
		System.out.printf("15번째 이후 평균: %f\n", avg15Up);
	}
}
