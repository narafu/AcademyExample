package com.narafu.practice.test.example;

public class Example02 {

	int count;

	public static void main(String[] args) {

		Example02 example = new Example02();
		Counter02 counter = new Counter02();

		counter.update(example);
		System.out.println(example.count);

	}

}

class Counter02 {

	public void update(Example02 example) {
		// TODO Auto-generated method stub
		example.count++;
	}


}