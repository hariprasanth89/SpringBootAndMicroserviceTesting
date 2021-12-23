package com.example.demo;

public class RecursionPrograms {
	
	public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        System.out.println(str);
        return reverseString(str.substring(1)) + str.charAt(0);
    }
	
	public static int getNumbers(int n) {
		
		System.out.println(n);
		if (n < 1) {
			return n;
		}
		return getNumbers(n-1);
	}
	
	
	public static int getno(int n) {
		if((n<=1)) {
			System.out.println(n);
			return n;
		} else {
			System.err.println(n);
		}
		return getno(n-1);
	}

	public static void main(String[] args) {
		
//		int getno = getno(5);
//		System.out.println("sam" + getno);
//		
//		int numbers = getNumbers(5);
//		System.err.println(numbers);

		String str = "Welcome to Beginnersbook";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
		
	}

}
