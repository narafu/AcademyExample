package com.narafu.practice.test.example;

public class Example01 {

	int count;

	public static void main(String[] args) {

		Example01 example = new Example01();
		Counter01 counter = new Counter01();

		counter.update(example.count);
		System.out.println(example.count);

	}

}

class Counter01 {

	public void update(int count) {

		count++;

	}

}