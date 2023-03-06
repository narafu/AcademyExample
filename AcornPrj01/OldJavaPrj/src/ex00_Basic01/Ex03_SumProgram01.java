package ex00_Basic01;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03_SumProgram01 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data.out");
//		강아지(개체) 다롱이(객체) = new 강아지(개체)

		fos.write(65); // A
		fos.write(51); // 3
		fos.write(52); // 4
		fos.write(49); // 1
		fos.write(49 + 1); // 2
		fos.write('1'); // 1
		fos.write('1' + 1); // 2

		fos.write('H');
		fos.write('e');
		fos.write('l');
		fos.write('l');
		fos.write('o');
		
		fos.close(); // 파일 종료하기 위해

		System.out.println("작업완료");
	}

}
