package ex13_예외처리;

public class Program {

	public static void main(String[] args) {

		int result1 = 0;
		int result2 = 0;
		int result3 = Calculator.div(10, 0);

//		try {
			result1 = Calculator.add(103, 8);
			result2 = Calculator.sub(10, 33);
//		}

//		catch (음수를만드는예외 e) {
//			System.out.println("음수가 되는 오류가 발생하였습니다.");
//		}

//		catch (Exception e) { // exception 모든 오류를 잡아냄
//			System.out.println("100을 넘는 오류가 발생하였습니다.");
//		}

//		finally { // 무조건 실행
//			System.out.println("마지막 정리할 것이 있으면");
//		}

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);

		// RuntimeException은 실행 후에 파악하게 한다.
		
	}

}
