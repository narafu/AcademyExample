package com.narafu.practice.animal;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Animal cat = new Animal();
		System.out.print("입력 > ");
		cat.setName(scan.next());

		System.out.println("고양이 이름 : " + cat.getName());

		Dog dog = new Dog();
		dog.setName("멍멍");
		System.out.println("강아지 이름 : " + dog.getName());
		dog.sleep();
		
		
	}
}
