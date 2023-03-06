package com.narafu.practice.test.example01;

public class Program {

	public static void main(String[] args) {

		Counter counter = new Counter();
		Updater updater = new Updater();

		updater.update(counter.count);
		
		System.out.println(counter.count);

	}

}
