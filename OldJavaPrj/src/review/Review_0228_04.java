package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0228_04 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0228.jpg");

		int x;
		// Q1. while �ȿ��� �����ϸ� ������ �����?
		// Q2. �ʱⰪ�� ��� �Ǵµ�, � ����ϱ�?

		while ((x = fis.read()) != -1)
			fos.write(x);

		System.out.println("�۾��Ϸ�");

		fos.close();
		fis.close();

	}

}
