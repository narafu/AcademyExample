package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

//		콜렉션(Collection) : 라이브러리
//			: 라이브러리는 사용하는 방법만 알면 된다.
//		 	: (고정)배열 <-> 가변배열

		Set set = new HashSet(); // set의 식별자는 없다. 값 자체가 식별자이다.
		List list = new ArrayList(); // list의 식별자는 순서
		Map map = new HashMap(); // map의 식별자는 사용자가 지정한 키(key)

		
//		< set >
		set.add(3);
		set.add(4);
		set.add(3);
		set.add(4);
		// set의 식별자는 값
		// 값으로 구분하기에 2개
		// set만 할 수 있다. get할 수 없다. : set.get(0) X;
		// 식별자 없이 갖고 있는 값을 '열거'한다. 열거는 식별자가 필요없다. 있는 값을 그저 출력하면 된다.
		// set은 입력순서와 출력순서가 같지 않다.

		// 스레드의 안전한 콜렉션을 위해 set을 직접 갖지 않는다. (열거자: iterator)
		//// 멀티스레드에서 동일한 콜렉션을 공유하게 되면 불안전한 조회가 될 수 있다. (인덱스가 공유되기에..)
		////// 인덱스를 스레드마다 각자 갖게 하여 독립시켜야 한다.
		Iterator it = set.iterator(); // iterator : 열거하기 위한 인덱스를 발급하는 역할
		while (it.hasNext())
			System.out.println(it.next()); // 값이 끝났다.
		System.out.println("---------- 1 ----------");

		it = set.iterator(); // 열거할 인덱스를 새로 발급
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("---------- 2 ----------");

		// for-each
		//// 식별자를 거론하지 않고, 처음부터 끝까지 다 출력한다.
		for (Object n : set)
			System.out.println(n);
		System.out.println("---------- 3 ----------");

		Set set1 = new HashSet();
		set1.add(new Exam());
		set1.add(new Exam(20, 30, 40));
//		set.add("hello");
//		set.add(234.55);

		for (Object n : set1) {
			Exam exam = (Exam) n;
			System.out.println(exam.total());
		}
		System.out.println("---------- 4 ----------");

		Set<Exam> set2 = new HashSet<Exam>(); // Exam 형만 받도록. - 제네릭(Generic):"무엇이든 될 수 있는"
		set2.add(new Exam());
		set2.add(new Exam(20, 30, 40));
//		set2.add("hello");
		for (Exam exam : set2) {
			System.out.println(exam.total());
		}
		System.out.println("---------- 5 ----------");

//		< list >
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(4);
		// list의 식별자는 순서
		// 순서로 구분하기에 4개
		// 배열을 대체해서 주로 사용한다.

//		< map >
		map.put("id", 1);
		map.put("title", "hello");
		map.put("hit", 0);
		// map의 식별자는 사용자가 지정한 키(key)
		// 중복된 값을 허용하지 않는다. ('키'가 중복될 수 없기 때문에)
		// 임시객체를 쓸 때 주로 사용한다.

//		System.out.println(list.get(0));

	}

//	콜렉션(Collection) : 라이브러리
//	(고정)배열 <-> 가변배열
//	가변배열의 종류(Set, List, Map)
//	종류별 차이점은, 식별자의 차이
//	Set의 식별자는? (X) 값 == 식별자
////	=> 중복제거용으로 많이 사용
//	List의 식별자는? index
////	=> 배열의 대체제로 많이 사용
//	Map의 식별자는? 내가 정해준 컬럼 값
////	=> 객체형식을 대체하는 임시 객체로 많이 사용

//	식별자와 상관없이 데이터를 순회하는 방법의 필요성
////	Iterable 인터페이스(iterator())
////	"index", hasNext(), next(); => index를 개별화
////////	스레드에 안전한 열거를 위해서 => iterator()를 통해서 index를 개별화

//  열거하는 데이터가 객체일 경우에 ..
//// 	그 기능을 사용하는 방법에서 형식을 변환해야만 하는 불편함이 있다.
////	또한 형식 변환에서 치명적인 오류가 발생한다. - 제한없이 아무 자로형이나 다 받게 된다. -> 제네릭
	
}
