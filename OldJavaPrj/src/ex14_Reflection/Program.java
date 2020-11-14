package ex14_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Program {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {

		// ��ü�� �����ϴ� �� �ٸ� ��� : Class ��ü�� �̿�

		Class clsInfo = Class.forName("ex14_Reflection.Exam");
//		Method[] methods = clsInfo.getMethods();
		Method[] methods = clsInfo.getDeclaredMethods();

		for (int i = 0; i < methods.length; i++)
			System.out.println(methods[i].getName());

		System.out.println("---------------------------------------");

		Exam exam = (Exam) clsInfo.getDeclaredConstructor().newInstance(); // new Exam();
		exam.setKor(10);
		System.out.println("> total : " + exam.total());
		


//		Class examInfo = exam.getClass();
//		Method[] methods1 = examInfo.getDeclaredMethods();

//		for (int i = 0; i < methods1.length; i++)
//			System.out.println(methods1[i].getName());

	}

}
