package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram06 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\example3.txt");
		PrintStream ps = new PrintStream(fos);
		ps.printf("%d %d %d %d", 21, 32, 11, 39);

		ps.close();
		fos.close();

		FileInputStream fis = new FileInputStream("C:\\Workspace\\example3.txt");
		Scanner scan = new Scanner(fis);
		int w = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();

		scan.close();
		fis.close();

		System.out.println(x);
		System.out.println(y);
		System.out.println(w + z);

	}

}
