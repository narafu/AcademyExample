package ex00_Basic02;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ex03_SumProgram03 {

	public static void main(String[] args) throws IOException {

		FileInputStream iin = new FileInputStream("C:\\Workspace\\data3.txt");
		Scanner scan = new Scanner(iin);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int result = x + y;
		
		System.out.println(result);
		scan.close();
		iin.close();
		
		FileOutputStream oout = new FileOutputStream("C:\\Workspace\\data4.txt");
		PrintStream pri = new PrintStream(oout);
		pri.println(result);
		
		pri.close();
		oout.close();
		
	}

}
