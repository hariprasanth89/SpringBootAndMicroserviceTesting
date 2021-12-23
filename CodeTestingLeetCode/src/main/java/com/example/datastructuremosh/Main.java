package com.example.datastructuremosh;

public class Main {
	
	
	public static void main(String[] args) {
		Array numbers = new Array(3);
		numbers.inser(10);
		numbers.inser(20);
		numbers.inser(30);
		numbers.inser(40);
		//System.out.println(numbers.indexOf(20));
		//numbers.removeat(1);
		//numbers.print();
		
		
		var list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.indexOf(20);
		list.removeFirst();
	}

}
