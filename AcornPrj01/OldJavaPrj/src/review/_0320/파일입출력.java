package review._0320;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ��������� {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0320.txt");
		fos.write(50);
		fos.write(30);

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0320.txt");
		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.\n", x, y, z);

		PrintStream ps = new PrintStream(fos);
		ps.println(100);
		ps.println(72);

		Scanner scan = new Scanner(fis);
		 x = scan.nextInt();
		 y = scan.nextInt();
		 z = x + y;

		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);
	}

}
