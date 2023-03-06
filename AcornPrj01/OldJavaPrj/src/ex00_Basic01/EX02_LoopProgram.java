package ex00_Basic01;

public class EX02_LoopProgram {

	public static void main(String[] args) {

		int x = 0;

		while (true) {

			x += 2; // (x = x + 2)과 같은 의미.
					// 1을 누적할 경우 (x += 1;) 보다는 x++로 쓰는 것이 바람직하다.

			
			System.out.println(x%2==0);

		}

	}

}
