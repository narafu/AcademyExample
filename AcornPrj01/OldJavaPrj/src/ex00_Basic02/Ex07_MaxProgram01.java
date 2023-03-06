package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_MaxProgram01 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		String num;
		int n;
		int max = scan.nextInt();

		while (scan.hasNext()) {

			num = scan.next();
			n = Integer.parseInt(num);

			if (max < n)
				max = n;

		}

		scan.close();
		fis.close();

		System.out.printf("최대값은 %d\n", max);

	}

}
