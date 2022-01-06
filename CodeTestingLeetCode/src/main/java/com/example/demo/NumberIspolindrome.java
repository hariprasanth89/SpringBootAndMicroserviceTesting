package com.example.demo;

public class NumberIspolindrome {
	 
	
	public static boolean isPalindrome(int x) {
	        String str = String.valueOf(x);
	        
	        int start = 0;
	        int end = str.length()-1;
	        
	        while(start < end){
	            if(str.charAt(start++) != str.charAt(end--))return false;
	        }
	        return true;
	    }
	
	public static void polindromeNumber(int x)
	{
		int refer = x;
		int reminder,revers = 0;
		
		while(x>0) {
			reminder = x%10;
			revers = (revers*10)+reminder;
			x =x/10;
		}
		if(refer == revers) {
			System.out.println("Given number polindrom");
		} else {
			System.out.println("Given number not polindrom");
		}
	}
public static void main(String[] args) {
	polindromeNumber(121);
}
}
