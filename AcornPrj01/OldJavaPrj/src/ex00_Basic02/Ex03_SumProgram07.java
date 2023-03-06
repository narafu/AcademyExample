package ex00_Basic02;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Ex03_SumProgram07 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\Workspace\\data5.txt");
		PrintStream ps = new PrintStream(fos);

		ps.print("abcdefg");
		
		ps.close();
		fos.close();

		System.out.println("작업완료");

	}

}
