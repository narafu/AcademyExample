package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0305_01a {

	public static void main(String[] args) throws IOException {

		// ���ڿ�, ���� ���

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0305s.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0305s.txt");

		PrintStream ps = new PrintStream(fos);
		Scanner scan = new Scanner(fis);

		ps.println(50);
		ps.println(100);

		int x = Integer.parseInt(scan.next());
		int y = Integer.parseInt(scan.next());
		int z = x + y;

		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);
		
		scan.close();
		ps.close();

	}

}
