package com.narafu.practice.test.example02;

public class Program {

	public static void main(String[] args) {

		Updater updater = new Updater();
		Counter counter = new Counter();
		
		updater.update(counter);
		
		System.out.println(counter.getCount());
		
	}

}
