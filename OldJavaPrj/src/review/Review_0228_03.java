package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0228_03 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0228.txt");
		PrintStream ps = new PrintStream(fos);

		ps.println(35);
		ps.println(45);
		ps.println(85);
		
		// ���� �༮���� �� ������ ���� �� ������? void?

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0228.txt");
		Scanner scan = new Scanner(fis);

		int a = Integer.parseInt(scan.next());
		int b = Integer.parseInt(scan.next());
		int c = Integer.parseInt(scan.next());
		int d = a + b + c;

		System.out.printf("a(%d), b(%d, c(%d)�� ���� %d", a, b, c, d);
		
		scan.close();
		fis.close();
		ps.close();
		fos.close();

	}

}
