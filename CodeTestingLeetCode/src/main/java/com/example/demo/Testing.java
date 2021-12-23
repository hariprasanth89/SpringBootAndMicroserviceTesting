package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import com.example.time.arrayindex.SwapOddAndEvenTimeComplexity;

public class Testing extends SwapOddAndEvenTimeComplexity {
	
	public static int findBalancedArray(List<Integer> arr)
    {
        int size = arr.size();
        int right_sum = 0, left_sum = 0;
        for (int i = 1; i < size; i++)
            right_sum += arr.get(i);
        for (int i = 0, j = 1; j < size; i++, j++) {
            right_sum -= arr.get(j);
            left_sum += arr.get(i);
            if (left_sum == right_sum)
            	System.out.println(arr.get(i) );
                return arr.get(i);
        }
        return -1;
    }
	
	
	private static int extracted(String s) {
        for(char i : s.toCharArray()){
            if ( s.indexOf(i) == s.lastIndexOf(i)) {
            	System.out.println(s.indexOf(i));
                return s.indexOf(i);
            }
        }
        return -1;
    }
	
	private static String ReversedLast2charAndAppendSpaceBetween(String word) {
	    return word.charAt(word.length()-1) +  " " + word.charAt(word.length()-2);
	}
	
	public int hammingDistance(int x, int y) {
        int xor = x^y;
        int count = 0;
        while (xor > 0) {
            if ((xor&1) == 1) {
                count ++;
            }
            xor = xor >> 1;
        }
        return count;
    }
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {			 
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i; 
					result[1] = j;
					return result;
				}
			}
		}
		return nums;
    }
	
	
	public static void main(String[] args) {
		
		
		
		String txt = "Please locate where 'locate' occurs!";
	    System.out.println(txt.charAt(txt.length()-2));
	    //String  s = "Apple";
	    //ReversedLast2charAndAppendSpaceBetween(s);
	    List<Integer> s = new ArrayList<Integer>();
	    s.add(1);
	    s.add(2);
	    s.add(3);
	    s.add(4);
	    s.add(5);
	    
	   // findBalancedArray(s);
	   // 
	   int nums[] = new int[] {2, 7, 11, 15};
	   int target = 9;
	   int[] twoSum = twoSum(nums, target);
	   System.out.println("["+twoSum[0] + "," + twoSum[1]+"]");
	    
	    
	}

}
