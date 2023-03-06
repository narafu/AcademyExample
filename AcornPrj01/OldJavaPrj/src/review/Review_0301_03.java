package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0301_03 {

	public static void main(String[] args) throws IOException {

		// img.jpg 파일을 1byte씩 복사하기

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0301.jpg");
		Scanner scan = new Scanner(fis);

		int x;
		while ((x = fis.read()) != -1)
			fos.write(x);

		System.out.println("작업완료");

		fos.close();
		fis.close();
		scan.close();

	}

}
