package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram10 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");

		Scanner scan = new Scanner(fis);

		int count = 0;
		int total10Up = 0;
		float avg10Up;
		
		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 10)
				total10Up += n;
		}
		
		avg10Up = (float) total10Up / count-9;

		scan.close();

		System.out.printf("10번째 이후 수들의 총합: %d\n", total10Up);
		System.out.printf("10번째 이후 수들의 평균: %f\n", avg10Up);

	}
}
