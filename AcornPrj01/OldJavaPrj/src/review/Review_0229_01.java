package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0229_01 {

	public static void main(String[] args) throws IOException {

		// x, y���� ���� �������� data.txt �Է��ϰ�, �ֿܼ� ���(z) ����ϱ�

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0229.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0229.txt");

		fos.write(100);
		fos.write(1000);

		fos.close();

		int x = fis.read();
		int y = fis.read();
		int z = x + y;

		fis.close();
		System.out.printf("x(%d)�� y(%d)�� ����  z(%d)�Դϴ�.", x, y, z);

	}
}
