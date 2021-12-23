package com.example.datastructuremosh;

public class Array {
	
	private int[] items;
	private int count;
	
	public Array(int length) {
		this.items  = new int[length];
	}
	
	public void inser(int item) {
		if (this.items.length == this.count) {
			int[] newItems = new int[this.count * 2];
			for (int i = 0; i < this.count; i++)
				newItems[i] = this.items[i];
			this.items = newItems;
		}
		this.items[this.count++] = item;
	}
	
	public void removeat(int index) {
		if (index < 0 || index >= this.count) 
			throw new IllegalArgumentException();
		for (int i = index ; i < this.count; i++)
			items[i] = items[i + 1];
		
		this.count--;			
	}
	
	public int indexOf(int item) {
		for(int i = 0; i < this.count; i++) 
			if (this.items[i] == item) 
				return i;
		return -1;
	}
	
	public void print() {
		
		for (int i = 0; i < this.count; i++) {
			System.err.println("" + items[i]);
		}
		
	}

}
