package ex00_Basic01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex04_BinProgram {

	public static void main(String[] args) throws IOException {

//		1. 숫자 23과 34를 문자가 아닌 숫자 그대로 파일에 쓰기를 하고,
		FileOutputStream fos = new FileOutputStream("C:\\workspace\\data-b.txt");
		fos.write(23);	// -> 8bit:1Byte max (0~255), 256 이상은 저장하지 못한다. 
		fos.write(34);	// 버퍼에 내용을 기록(저장)
		fos.flush();	// 버퍼에 남겨진 내용들을 보내는 함수
		fos.close();
		
//		2. 파일에서 숫자를 그대로 읽어서
		FileInputStream fis = new FileInputStream("C:\\workspace\\data-b.txt");
		int x = fis.read();
		int y = fis.read();
		fis.close();
		int result = x + y;

//		3. 그 결과를 콘솔에 출력한다.
		System.out.println(result);

	}

}