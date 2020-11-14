package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0229_02 {

	public static void main(String[] args) throws IOException {

		// x, y값을 문자열 형식으로 data.txt 입력하고, 콘솔에 결과(z) 출력하기

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0229.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0229.txt");

		PrintStream ps = new PrintStream(fos);
		Scanner scan = new Scanner(fis);

		ps.println(1000);
		ps.println(10000);
		ps.close();

		int x = Integer.parseInt(scan.next());
		int y = Integer.parseInt(scan.next());
		int z = x + y;

		scan.close();
		System.out.printf("x(%d)와 y(%d)의 합은 z(%d)입니다.", x, y, z);

	}
}
