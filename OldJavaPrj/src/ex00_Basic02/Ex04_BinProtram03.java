package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_BinProtram03 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data6.txt");
		fos.write(55);
		fos.write(73);
		fos.flush();

		fos.close();

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data6.txt");
		int x = fis.read();
		int y = fis.read();

		fis.close();

		System.out.println(x);
		System.out.println(y);
		System.out.println("작업완료");

	}

}
