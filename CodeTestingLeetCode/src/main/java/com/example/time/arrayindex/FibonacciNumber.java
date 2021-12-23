package com.example.time.arrayindex;

public class FibonacciNumber {
	
	
	public static int fibonacci(int n) {
		  if (n == 0) {
		    return 0;
		  } else if (n == 1) {
		    return 1;
		  }
		  System.out.println(n);
		  return fibonacci(n - 1) + fibonacci(n - 2);
		 }

	
	public static int fibonacci(int n, int[] cache){
		  if (n == 0) {
		   return 0;
		  } else if (n == 1) {
		   return 1;
		  }

		  // Return cache value if it already exists
		  if (cache[n] != 0) {
		    return cache[n];
		  }

		  // Cache answer so later calls can use it
		  cache[n] = fibonacci(n - 1) + fibonacci(n - 2);

		  return cache[n];
		 }
	public static void main(String[] args) {
		
		//int fibonacci = fibonacci(5);
		//System.out.println(fibonacci);
		int[] nu = {1,2,6,5,7};
		System.out.println(fibonacci(nu.length-1, nu));

	}

}
