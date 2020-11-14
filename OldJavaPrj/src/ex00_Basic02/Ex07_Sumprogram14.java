package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram14 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int max = scan.nextInt();
		int count = 0;

		while (scan.hasNext()) {

			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count > 16)
				if (max < n)
					max = n;
		}

		scan.close();

		System.out.printf("15번째 이후 최대값: %d", max);
	}
}
