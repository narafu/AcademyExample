package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0301_01 {

	public static void main(String[] args) throws IOException {

		// x, y���� ���� �������� data.txt �Է��ϰ�, �ֿܼ� ���(z) ����ϱ�

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0301.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0301.txt");

		fos.write(88);
		fos.write(767);

		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		System.out.printf("x(%d)�� y(%d)�� ���� z(%d)�Դϴ�.", x, y, z);

		fis.close();
		fos.close();

	}

}
