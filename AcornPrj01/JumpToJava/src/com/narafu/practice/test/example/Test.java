package com.narafu.practice.test.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// String 클래스 - indexOf()
		String test = "Hello Java!";
		System.out.println(test.indexOf("a!"));

		// String 클래스 - equals()
		String test_ = "Hello java";
		System.out.println(test.equals(test_));

		// String 클래스 - replaceAll()
		System.out.println(test.replace("ello", "i"));

		// String 클래스 - subString()
		System.out.println(test.substring(6, 10));

		// StringBuffer - append()
		StringBuffer sb = new StringBuffer(test);
		System.out.println(sb.append("!"));

		// StringBuffer - insert()
		System.out.println(sb.insert(5, " Hi"));

		// Array
		int[] array = new int[10];
		System.out.println("array : " + array);
		System.out.println("array : " + Arrays.toString(array));

		// List : ArrayList : get() good
		List<String> arrayList = new ArrayList<String>();
		arrayList.add("5");
		arrayList.add("콜라");
		System.out.println("arrayList : " + arrayList);
		System.out.println(arrayList.size()); /* size() */
		System.out.println(arrayList.contains("3")); /* contain() */
		System.out.println(arrayList.remove("콜라")); /* remove() */
		System.out.println(arrayList.remove(0)); /* remove() */
		System.out.println("arrayList : " + arrayList);

		// List : LinkedList : add() & remove() good
		List<String> linkedList = new LinkedList<String>();
		System.out.println("linkedList : " + linkedList);
		System.out.print("입력 : > ");
		linkedList.add(scan.next());
		System.out.println("linkedList : " + linkedList);

		// Map : HashMap
		Map<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(5, "사이다");
		System.out.println("hashMap : " + hashMap);
		System.out.println(hashMap.get(5));
		
		// for-each
		for(String var : linkedList) {
			System.out.println(var);
		}
		
	}

}
