package ex00_Basic01;

public class EX02_LoopProgram {

	public static void main(String[] args) {

		int x = 0;

		while (true) {

			x += 2; // (x = x + 2)�� ���� �ǹ�.
					// 1�� ������ ��� (x += 1;) ���ٴ� x++�� ���� ���� �ٶ����ϴ�.

			
			System.out.println(x%2==0);

		}

	}

}
