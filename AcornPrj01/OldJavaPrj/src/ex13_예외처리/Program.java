package ex13_����ó��;

public class Program {

	public static void main(String[] args) {

		int result1 = 0;
		int result2 = 0;
		int result3 = Calculator.div(10, 0);

//		try {
			result1 = Calculator.add(103, 8);
			result2 = Calculator.sub(10, 33);
//		}

//		catch (����������¿��� e) {
//			System.out.println("������ �Ǵ� ������ �߻��Ͽ����ϴ�.");
//		}

//		catch (Exception e) { // exception ��� ������ ��Ƴ�
//			System.out.println("100�� �Ѵ� ������ �߻��Ͽ����ϴ�.");
//		}

//		finally { // ������ ����
//			System.out.println("������ ������ ���� ������");
//		}

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);

		// RuntimeException�� ���� �Ŀ� �ľ��ϰ� �Ѵ�.
		
	}

}
