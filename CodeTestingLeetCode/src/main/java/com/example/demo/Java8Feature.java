package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8Feature {
	
	FunctionalIntroByJava8 doSomeCal = () -> System.out.println("My first java featre testing");
	
	public void callTheFunc(FunctionalIntroByJava8 s) {
		s.functionalInterface();
	}
	public static void miniMaxSum(List<Integer> arr) {
	    // Write your code here
		
		List<Integer> arr1 = new ArrayList();

//        for (int i = 0; i < 5; i++) {
//            int arrItem = Integer.parseInt(arrTemp[i]);
//            arr.add(arrItem);
//        }
			arr.size();
			for(int i = 0; i<arr.size(); i++) {
				System.out.println(i);
			}
			
//	       long sum = 0;
//	        long max = Long.MIN_VALUE;
//	        long min = Long.MAX_VALUE;
//	        for (int i = 0; i < 5; i++){
//	            //int n = arr[i];
//	            sum += n;
//	            max = Math.max(max, n);
//	            min = Math.min(min, n);
//	        }
//	        System.out.println((sum - max) + " " + (sum - min));
	    }


	public static void main(String[] args) throws IOException {
		
		Java8Feature sam = new Java8Feature();
		//sam.callTheFunc();
		//miniMaxSum(null);
		
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        List<Integer> arr = new ArrayList<>();

	        for (int i = 0; i < 5; i++) {
	            int arrItem = Integer.parseInt(arrTemp[i]);
	            arr.add(arrItem);
	        }

	        Java8Feature.miniMaxSum(arr);

	        bufferedReader.close();
		
	}
	

}


interface FunctionalIntroByJava8{
	public void functionalInterface();
}