package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_BinProtram04 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data8.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data8.txt");

		fos.write(55);
		fos.write(100);
		fos.flush();

		int x = fis.read();
		System.out.println(x);
		int y = fis.read();
		System.out.println(y);

		fis.close();
		fos.close();

		System.out.println();
		System.out.println(x + y);
		System.out.println("작업완료");

	}

}
