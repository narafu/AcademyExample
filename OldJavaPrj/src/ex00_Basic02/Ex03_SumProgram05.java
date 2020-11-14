package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram05 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\example2.txt");
		PrintStream ps = new PrintStream(fos);
		ps.printf("%d %d %d", 432, 983, 375);
		
		ps.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:\\Workspace\\example2.txt");
		Scanner scan = new Scanner(fis);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int z = scan.nextInt();
		int sum = x + y + z;
		
		scan.close();
		fis.close();
		
		System.out.println(sum);
		
		
	}

}
