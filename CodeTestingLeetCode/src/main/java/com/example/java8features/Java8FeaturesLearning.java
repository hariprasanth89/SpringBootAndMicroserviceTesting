package com.example.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8FeaturesLearning{

	public void dosomeprocess(MyFunctionalInterface fa) {
		fa.getFunction();
	}
	
	
	public static void java8FeatureLearning() {
		Integer[] array =  {1,7,8,6,2,3,4,5};
		Integer[] arr1 = new Integer[array.length];
		String[] str = {"hari","tt","kk"};
		String[] str1 = new String[str.length];
		//int[] arrlen = null;
		
		List<Integer> collect = Arrays.asList(array).stream().filter(i -> i >= 5).map(i ->i*2).collect(Collectors.toList());
		//Arrays.copyOf(null, arr1.length-1);
		//Arrays.copyOf(array, arrlen.length);
		System.out.println();
		System.arraycopy(array, 0, arr1, 0, array.length);
		System.arraycopy(str, 0, str1, 0, str.length);
		Arrays.sort(array);
		for(Integer i : array) {
			System.out.println(i);
		}
		
		System.out.println(arr1);
	}
	
	
	public static void main(String[] args) {
		java8FeatureLearning();
		
		MyFunctionalInterface ob = () -> System.out.println("functiona interface");
		//ob.getFunction();
		Java8FeaturesLearning as = new Java8FeaturesLearning();
		as.dosomeprocess(ob);
		
	}
	
	
}
