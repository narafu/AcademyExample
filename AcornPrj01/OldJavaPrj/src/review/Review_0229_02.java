package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Review_0229_02 {

	public static void main(String[] args) throws IOException {

		// x, y���� ���ڿ� �������� data.txt �Է��ϰ�, �ֿܼ� ���(z) ����ϱ�

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
		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);

	}
}
