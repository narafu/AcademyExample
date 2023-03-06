package ex00_Basic01;
public class Ex06_ConsoleCopyProgram3 {

	public static void main(String[] args) {

		byte a = 3; // byte(1) 형식에 int(4) 값을 담았다. / 기본크기가 4byte
//		byte b = 3L; // byte(1) 형식에 long(8) 값을 담았다. / 형식과 값이 다르지만, 값이 이 더 커서, 오류
		int c = a; // int(4) 형식에 byte(1) 값을 담았다. / 형식과 값이 다르지만, 공간이 더 커서, 자동변환
		
//		float d = 3.4; // float(4) 형식에 double(8) 값을 담았다. / 형식과 값이 다르지만, 값이 이 더 커서, 오류
		double e = 3.4f; // double(8) 형식에 float(4) 값을 담았다. / 형식과 값이 다르지만, 공간이 더 커서, 자동변환
		double f = 3; // double(8) 형식에 int(4) 값을 담았다. / 형식과 값이 다르지만, 공간이 더 커서, 자동변환
//		int g = 3.4f; // int(4) 형식에 float(4) 값을 담았다. / 크기는 같은데, 정수 변수에 실수 값이라서 오류?

		char h = 65; // char(2) 형식에 int(4) 값을 담았다. / 묵시적 형변환
		int i = 'A'; // int(4) 형식에 char(2) 값을 담았다. / 묵시적 형변환
//		System.out.println(h);
		
//		boolean j = 1; // X
//		boolean k = (boolean) 1; // X
		
		// 형식과 값이 차이가 있을 때, 되는 것은, 묵시적 형변환 때문이다.
		
//		String l = 3.4;
		String.valueOf(3.4); // 실수를 문자열로 
		
//		float m = "3.4";
		Float.parseFloat("3.4"); // 문자열을 실수로

//		int n = "3";
		Integer.parseInt("3"); // 문자열을 정수로
		
//		boolean o = "true";
		Boolean.parseBoolean("true"); // 문자열을 부울로
		
		String p = "34.2";
		Double.parseDouble("34.2"); // 문자열을 실수double로
		

	}

}