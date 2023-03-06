package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram10 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data7.txt");
		FileInputStream fis = new FileInputStream("C:\\Workspace\\data7.txt");
		PrintStream ps = new PrintStream(fos);
		Scanner scan = new Scanner(fis);

		ps.println(55);
		ps.print(100);

		String x = scan.next();
		int X = Integer.parseInt(x);
		System.out.println(x);
		System.out.println(X);
		
		String y = scan.next();
		int Y = Integer.parseInt(y);
		System.out.println(y);
		System.out.println(Y);		

		scan.close();
		ps.close();
		fis.close();
		fos.close();
		

		System.out.println();
		System.out.println(x + y);
		System.out.println(X + Y);
		System.out.println("작업완료");

	}

}
