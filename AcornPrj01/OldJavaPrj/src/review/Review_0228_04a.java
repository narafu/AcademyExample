package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Review_0228_04a {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\img.jpg");
		Scanner scan = new Scanner(System.in);
		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\img0228.jpg");

		while (scan.hasNext()) {
			int copy = Integer.parseInt(scan.next());
			fos.write(copy);
		}

		System.out.println("작업완료");

		scan.close();
		fos.close();
		fis.close();

	}

}
