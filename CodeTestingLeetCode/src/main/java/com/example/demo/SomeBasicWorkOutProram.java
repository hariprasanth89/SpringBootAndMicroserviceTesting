package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class SomeBasicWorkOutProram {

	private static List<Integer> arrConcept(int[] arr) {
		List<Integer> nums = new ArrayList<Integer>();
		int len = arr.length;
		int temp;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			nums.add(arr[i]);
			System.out.println(arr[i]);
		}
		System.out.println(arr[arr.length/2]);
		return nums;
	}
	
	public static String  stringFunction(String s ) {
		int len = s.length();
		String[] split = s.split(" ");
		int max =0;
		int min = 0;
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
			max = Math.max(max, split[i].length());
			
			min = Math.min(min, split[i].length());
		}
		System.out.println(max);
		System.out.println("min" + min);
		return s;
		
	}
	
	
	public ArrayList<Integer> twoarraymerge(int[] nums1, int[] nums2) {
		
		//ArrayCon
		
		return null;
	}
	
	public static String duplicatewords(String s) {
		int length = s.length();
		System.out.println(length);
		String[] split = s.split(" ");
		System.out.println("spilt : " + split.length);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String keys : split) {
			if (map.get(keys) != null) {
				map.put(keys, map.get(keys)+1);
			} else {
				map.put(keys, 1);
			}
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String keysValue = (String) iterator.next();
			if (map.get(keysValue) > 1) {
				System.out.println(" Duplicated keys   : " + keysValue +  " \n         value:   "+ map.get(keysValue));
			}
		}
		System.out.println(map);
		return null;
	}
	
	public static void findDuplicateChare(String s) {
		Map<Character, Integer>map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char eachCharAt = s.charAt(i);
			if (map.get(eachCharAt) != null) {
				map.put(eachCharAt, map.get(eachCharAt)+1);
			} else {
				map.put(eachCharAt, 1);
			}
		}
		map.forEach((k,v)->System.out.print(k +"  "));  // one approach
		System.out.println();
		map.values().forEach(k ->System.out.print(k + "  "));
		System.out.println();
		map.keySet().forEach(c->System.out.print(c + "  "));
		System.out.println();
		
		Iterator<Character> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Character character = (Character) iterator.next();
			if (map.get(character) >1) {
				System.out.println("charaters ::::    " + character +  "     values     "+ map.get(character) );
			}
		}
		
		
	}
	
	public static void palindrome() {
		String str = "hari got the job got the job";
		
		String[] split = str.split(" ");
		for (int i = 0; i < split.length; i++) {
			String strReverse = new StringBuffer(split[i]).reverse().toString();
			if (strReverse.equals(split[i])){
					
				}
			}
	}
	
	
	
	

	public static void main(String[] args) {
		
		int[] arrs = {10,8,12,9,6,1,2,3};
		//arrConcept(arrs);
		
		String s = "Hari is person the best ";
		//stringFunction(s);
		
		String str = "hari got the job got the job";
		//duplicatewords(str);
		String str1 = "JavaandJ22ee";
		findDuplicateChare(str1);
	}
}
