package review;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0228_07 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\JavaPrj\\res\\data.txt");
		Scanner scan = new Scanner(fis);

		int aaa = scan.nextInt();
		int max = aaa;
		int min = aaa;

		while (scan.hasNext()) {
			int num = scan.nextInt();
			if (max < num)
				max = num;
			if (min > num)
				min = num;
		}

		System.out.printf("최대값: %d\n", max);
		System.out.printf("최소값: %d", min);

		scan.close();
		fis.close();

	}

}
