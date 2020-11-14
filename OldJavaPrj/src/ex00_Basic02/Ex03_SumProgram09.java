package ex00_Basic02;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex03_SumProgram09 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Workspace\\data1.txt");
		Scanner scan = new Scanner(fis);

		int x = scan.nextInt();
		int y = scan.nextInt();

		System.out.println(x);
		System.out.println(y);
		System.out.println(x + y);

		scan.close();
		fis.close();

	}

}
