package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0228_04 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0228.jpg");

		int x;
		// Q1. while 안에서 선언하면 오류가 생길까?
		// Q2. 초기값이 없어도 되는데, 어떤 경우일까?

		while ((x = fis.read()) != -1)
			fos.write(x);

		System.out.println("작업완료");

		fos.close();
		fis.close();

	}

}
