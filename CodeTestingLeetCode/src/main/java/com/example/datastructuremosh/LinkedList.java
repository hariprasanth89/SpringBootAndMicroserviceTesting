package com.example.datastructuremosh;

import java.util.NoSuchElementException;

public class LinkedList {
	
	private class Node {
		
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value =value;
		}
		
	}
	public boolean isEmpty() {
		return this.first == null;
	}
	 
	private Node first;//   head 
	private Node last;//  tail 
	
	public void addLast(int item) {
		var node = new Node(item);
		if (this.isEmpty()) 
			this.first = this.last = node;
		else {
			this.last.next = node;
			this.last = node;
		}
	}
	
	public void addFirst(int item) {
		var node = new Node(item);
		if(this.isEmpty())
			this.first = this.last = node;
		else {
			node.next = this.first;
			this.first = node;
		}
	}
	
	public int indexOf(int item) {
		int index = 0;
		//var current = this.first;
		Node current = this.first;
		while (current != null) {
			if(current.value == item) return index;
			current = current.next;
			index++;				
		}
		return -1;
	}
	
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	
	public void removeFirst() {
		if (this.isEmpty())
			throw new NoSuchElementException();
		if (this.first == this.last) {
			this.first = this.last = null;
			return;
			}
			var second = this.first.next;
			this.first.next = null;
			this.first = second;
}
	
	

}
