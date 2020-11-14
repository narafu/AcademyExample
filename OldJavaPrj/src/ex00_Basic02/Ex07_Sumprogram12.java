package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex07_Sumprogram12 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("res/data.txt");
		Scanner scan = new Scanner(fis);

		int count = 0;
		int max60Up = scan.nextInt();
		System.out.println(max60Up);

		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 60)
				if (max60Up < n)
					max60Up = n;
		}

		int min60Up = 9999;
		System.out.println(min60Up);

		while (scan.hasNext()) {
			String num = scan.next();
			int n = Integer.parseInt(num);
			count++;
			if (count >= 60)
				if (min60Up > n)
					min60Up = n;
		}

		scan.close();

		System.out.printf("60번째 이후의 최소값: %d\n", min60Up);
		System.out.printf("60번째 이후의 최대값: %d\n", max60Up);

	}
}

// scanNext 가 다 읽어서, 끝난 뒤에는 두번째 while 구문이 안되는건가?