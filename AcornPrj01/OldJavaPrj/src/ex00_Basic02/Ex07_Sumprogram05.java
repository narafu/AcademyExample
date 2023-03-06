package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram05 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		String num;
		int sum = 0;
		int count = 0;
		float avg;
		while (scan.hasNext()) {
			num = scan.next();
			sum += Integer.parseInt(num);
			count++;
		}

		scan.close();
		fis.close();

		avg = (float) sum / count;

		System.out.printf("total is %d\n", sum);
		System.out.printf("count is %d\n", count);
		System.out.printf("averge is %f\n", avg);

	}
}
