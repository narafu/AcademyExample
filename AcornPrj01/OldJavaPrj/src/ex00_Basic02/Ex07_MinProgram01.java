package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_MinProgram01 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		String num;
		int n;
		int min = scan.nextInt();

		while (scan.hasNext()) {

			num = scan.next();
			n = Integer.parseInt(num);

			if (min > n)
				min = n;

		}

		scan.close();
		fis.close();

		System.out.printf("최소값은 %d\n", min);

	}

}
