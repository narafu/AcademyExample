package review;

import java.util.Scanner;

public class Review_0228_05 {

	public static void main(String[] args) {

	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("파일명 입력 > ");
		String fileName = scan.next();
		
		System.out.println();
		System.out.printf("파일명 출력: %s\n", fileName);
		System.out.printf("파일명 변환: %s\n", fileName.toUpperCase());
		System.out.printf("파일명 길이: %d\n", fileName.length());
		
		scan.close();
	}

}
