package ex00_Basic01;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//     (패키지)    (클래스) 
// 패키지 > 클래스(개체 entity) > 인스턴스(객체 object)

public class Ex03_SumProgram03 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\workspace\\data.txt");
		
		int ch;

		ch = fis.read();
		System.out.println(ch);

		ch = fis.read();
		System.out.println(ch);
		
		fis.close();

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data.out");
//		강아지(개체) 다롱이(객체) = new 강아지(개체)

		PrintStream out = new PrintStream(fos);
		out.print("Hello");
		out.close();

		System.out.println("작업완료");
	}

}
