package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class LeetCodeProblemSolve {
	
	public static int hammingDistance(int x, int y) {
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
	
	public static int reverseNumber(int n) {
		  
		int reversed = 0; // reversed number
	    int remainder = 0;   // remainder
	        
	     while(n>0){
	           
	        remainder = n%10;
	        reversed = (reversed*10) + remainder;
	        n = n/10;
	      }
	        System.out.println(reversed);
	        
	        
	    /*   for(;n != 0;) {
	    	   remainder = n%10;
		        reversed = (reversed*10) + remainder;
		        n = n/10;
		       // System.out.println(n);
		        System.out.println("\n"+reversed);
	       } */
	        
	        
	      return reversed;
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
	/// other way to solve 
	public static int[] addTwoNumbers1(int nums[], int target) {
		Map<Integer, Integer> itemNumbers = new HashMap();
		for(int i = 0; i < nums.length; i++) {
			int delta = target - nums[i];  //2,3,7,4,8
			if (itemNumbers.containsKey(delta)) {
				return new int[] {itemNumbers.get(delta),i};
			}
			itemNumbers.put(nums[i], i);
		}
		return new int[] {-1,-1};
	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 
	        ListNode n1 = l1;
	        ListNode n2 = l2;
	        ListNode fakeHead = new ListNode(-1);
	        ListNode result = fakeHead;
	        int toAdd = 0;
	        while(!(n1 == null && n2 == null)){
	            int v1 = 0;
	            int v2 = 0;
	            if (n1 != null){
	                v1 = n1.val;
	                n1 = n1.next;
	            }
	            if (n2 != null){
	                v2 = n2.val;
	                n2 = n2.next;
	            }
	            int tmp = v1 + v2 + toAdd;
	            result.next = new ListNode(tmp % 10);
	            result = result.next;
	            toAdd = tmp / 10;

	        }
	        if (toAdd > 0){
	            result.next = new ListNode(toAdd);
	        }
	        return fakeHead.next;
	    }
	 
	 
	 public static int lengthOfLongestSubstring(String s) {
		 
		 boolean flag[] = new boolean[256];
		 int result = 0;
		 int start = 0;
		 char arr[] = s.toCharArray();
		 if (!s.isEmpty() && s != null) {
			 for(int i = 0; i < arr.length; i++) {
				 char current = arr[i];
				 if (flag[current]) {
					 result = Math.max(result, i - start);
					 for(int k = start; k < i; k++) {
						 if(arr[k] == current) {
							 start = k+1;
							 break;
						 }
						 flag[arr[k]] = false;
					 }
				 } else {
					 flag[current] = true;
				 }
			 }
		} else {
			System.out.println("String is emplty");
		}
		 result = Math.max(arr.length - start, result);
		 return result;
	 }
	 
	 
	 // 4. Median of Two Sorted Arrays
	 public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        int n = nums1.length + nums2.length;
	        int one = findKth(nums1, 0, nums2, 0, (n + 1)/2);
	        int two = findKth(nums1, 0, nums2, 0, (n + 2)/2);
	        return ((double)one + (double)two )/ 2.0;
	    }
	    private static int findKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
	        if (s1 >= nums1.length) {
	            return nums2[s2 + k - 1];
	        }    
	        if (s2 >= nums2.length) {
	            return nums1[s1 + k - 1];
	        }
	        if (k == 1) {
	            return Math.min(nums1[s1], nums2[s2]);
	        }
	        int m1 = s1 + k / 2 - 1;
	        int m2 = s2 + k / 2 - 1;
	        int mid1 = 0;
	        int mid2 = 0;
	        if (m1 >= nums1.length) {
	            mid1 = Integer.MAX_VALUE;
	        }
	        else {
	            mid1 = nums1[m1];
	        }
	        if (m2 >= nums2.length) {
	            mid2 = Integer.MAX_VALUE;
	        }
	        else {
	            mid2 = nums2[m2];
	        }
	        if (mid1 < mid2) {
	            return findKth(nums1, m1 + 1, nums2, s2, k - k/2);
	        }
	        else {
	            return findKth(nums1, s1, nums2, m2 + 1, k - k/2);
	        }
	    }
	    
	    //5 Longest Palindromic Substring
	    
	    public static String longestPalindrome(String s) {
	        String longest = "";
	        for (int i = 0; i < s.length(); i ++){
	            String tmp = "";
	            tmp = paCenterBy(s, i, i);
	            if (tmp.length() > longest.length()){
	                longest = tmp;
	            }
	            tmp = paCenterBy(s, i, i + 1);
	            if (tmp.length() > longest.length()){
	                longest = tmp;
	            }
	        }  
	        return longest;
	    }
	    private static String paCenterBy(String s, int cleft, int cright){
	        String result = "";
	        while (cleft >=0 && cright < s.length() && s.charAt(cleft) == s.charAt(cright)){
	            cleft --;
	            cright ++;
	        }
	        return s.substring(cleft + 1, cright);
	    }
	    
	    public static void printStarPattern(int n) {
	    	
	    	for(int i = 1; i<=n; i++) {
	    		for(int j = i; j<n; j++) {
	    			 System.out.print(" ");
	    		}
	                  for ( int k = 1 ; k <(i*2); k++)
	                      System.out.print("*");
	                  System.out.print("\n");
//	    			if(j%i ==2) {
//	    				
//	    			} else {
//	    				System.out.println("  *");
//	    			}
//	    			System.out.println();
	    		}
	    	
	    }
	    
	    public static void fibonacciSeries(int n) {
	    	int a = 0, b = 1, c;
	    	System.out.println(a + " " + b);
	    	for(int i = 0; i<n; i++) {
	    		c = a+b;
	    		System.out.println(c);
	    		a = b;
	    		b = c;
	    	}
	    }
	    
	    public static void primeNumber(int num) {
	    	
	    	
	    }
	    
	    public static ArrayList<Integer> printPrimeNumber(int start, int end){
	    		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
	    		for (int n = start; n < end; n++) {
	    			boolean prime = true;
	    			int i = 2;
	    			while(i <= n/2) {
	    				if(n % i ==0) {
	    					prime = false;
	    					break;
	    				}
	    				i++;
	    			}
	    			if(prime) {
	    				primeNumbers.add(n);
	    			}
				}
	    	return primeNumbers;
	    }
	    
	    
	    public static String stringReverseWithStringBuilder(String str) {
	    	StringBuilder sb = new StringBuilder();
	    	//String str1ValueManuallyAdding = "";
	    	if(str != null && !str.isEmpty()) {
		    	for(int i = str.length() - 1; i>=0; i--) {
		    		sb.append(str.charAt(i));
		    		//str1ValueManuallyAdding += str.charAt(i);
		    		//int indexOf = str.indexOf("H");
		    		//System.out.println(indexOf);
		    		
		    		//System.out.println(str1ValueManuallyAdding);
		    	}
	    	}
	    	return sb.toString();
	    }
	    
	    public static String stringReverseManually(String str) {

	    	return str != null ? new StringBuilder(str).reverse().toString() : "Given String is empty or null";
	    }
	    
	    
	    public static Boolean detectCapitalUse(String words) {
	    		if(words.length() <= 1) return true;
	    		Predicate<Character> correctCase = Character::isLowerCase;
	    		if(Character.isUpperCase(words.charAt(0)) 
	    				&& Character.isUpperCase(1)) {
	    			correctCase = Character::isUpperCase;
	    		}
	    		for(int i = 1; i < words.length(); i++) {
	    			if(!correctCase.test(words.charAt(i))) return false;
	    		}
	    	return true;
	    }
	    // one more solution to solve the problem  
	    public static String longestPolindrome(String str) {
	    	
	    	int strLength = str.length();
	    	if(strLength < 2) {
	    		return str;
	    	}
	    	
	    	return null;
	    }
	    
	    
	    public static int lengthOfLongestSubStringSoultion(String s) {
	    		int[] chars = new int[128];
	    		int left = 0;
	    		int right = 0;
	    		
	    		int res = 0;
	    		while(right < s.length()) {
	    			char r = s.charAt(right);
	    			chars[r]++;
	    			
	    			while(chars[r] > r) {
	    				char l = s.charAt(left);
	    				chars[l]--;
	    				left++;
	    			}
	    			res = Math.max(res, right - left + 1);
	    			right++;
	    		}
	    		
	    	return res;
	    }
	    public static int lengthOfLongestSubStringSoultion2(String s) {
    		Integer[] chars = new Integer[128];
    		int left = 0;
    		int right = 0;
    		
    		int result = 0;
    		while(right < s.length()) {
    			char eachChar = s.charAt(right);
    			
    			Integer index = chars[eachChar];
    			if(index != null && index >= left && index < right) {
    				left = index + 1;
    			}
    			
    			result = Math.max(result, right - left + 1);
    			chars[eachChar] = right; 
    			right++;
    		}
    	return result;
    }   // Time complexity : O(n) 
	    //space complexity : O(m)
    
	    
	    

	public static void main(String[] args) {
		
		int a = 2, b=4;
		hammingDistance(a, b);	
		 String s = "abcabcbb";
		 //int lengthOfLongestSubstring = lengthOfLongestSubstring(s);
		// System.out.println(lengthOfLongestSubstring);
		 
		 
		int nums1[] = {1,3};
		int nums2[] = {3};
		//double findMedianSortedArrays = findMedianSortedArrays(nums1, nums2);
		//System.out.println(findMedianSortedArrays);
		
		String str = "babad";
		//String longestPalindrome = longestPalindrome(str);
		//System.out.println(longestPalindrome);
		
		//printStarPattern(5);   
		//fibonacciSeries(5);
		
		int numbers[] = new int[] {2,3,7,4,8};
		int target = 7;
		
		//int[] addTwoNumbers1 = addTwoNumbers1(numbers, target);
		//System.out.println(addTwoNumbers1);
		
		
		String str1 = "Hari";
		//System.out.println(stringReverseManually(str1));
		//System.out.println(stringReverseWithStringBuilder(str1));
		
		String words = "Hari";
		//System.out.println(detectCapitalUse(words));
		int start =2; int end = 10;
		//System.out.println(printPrimeNumber(start, end));
		String longestSubString = "abcabcbb";
		//int lengthOfLongestSubStringSoultion = lengthOfLongestSubStringSoultion(longestSubString);
		//System.out.println(lengthOfLongestSubStringSoultion);
		int lengthOfLongestSubStringSoultion2 = lengthOfLongestSubStringSoultion2(longestSubString);
		//System.out.println(lengthOfLongestSubStringSoultion2);
		int numbers1 = 12345;
		int reverseNumber = reverseNumber(numbers1);
		System.out.println(reverseNumber);

	}
		public class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
	}

}


