package review;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Review_0228_02 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data0228.txt");

		fos.write(1000);
		fos.write(65);
		fos.write(75);
		fos.write(85);

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data0228.txt");

		int a = fis.read();
		int b = fis.read();
		int c = fis.read();
		int d = a + b + c;

		System.out.printf("a(%d), b(%d), c(%d)¿« «’¿∫ %d", a, b, c, d);

		fis.close();
		fos.close(); 

	}

}
