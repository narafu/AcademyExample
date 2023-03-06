package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram11 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int min15Up = scan.nextInt();
		System.out.println(min15Up);
		int max15Up = scan.nextInt();
		System.out.println(max15Up);
		int count = 0;

		while (scan.hasNext()) {

			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 15)
				if (max15Up < n)
					max15Up = n;
		}

		while (scan.hasNext()) {

			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 15)
				if (min15Up < n)
					min15Up = n;
		}

		scan.close();

		System.out.printf("15번째 이후 최대값: %d\n", max15Up);
		System.out.printf("15번째 이후 최소값: %d\n", min15Up);

	}
}
