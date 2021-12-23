package com.example.backtoback;

public class BacktoBackArrays {
	
	public int[] sortArray_0_1_2(int[] nums) {
		
		int count0 =0, count1=1, count2=2;
		
		for(int i = 0; i< nums.length; i++) {
			if(nums[i] == 0) count0++;
			if(nums[i] == 1) count1++;
			if(nums[i] == 2) count2++;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (i < count0) {
				nums[i] = 0;
			} else if (i < count0 + count1) {
				nums[i] = 1;
			} else nums[i] = 2;
		}
		
		
		return nums;
	}
	
	
	public static void main(String[] args) {
		
		int[] nums = {0,1,2,1,2,2,2,1,0};
		
		BacktoBackArrays backtoBackArrays = new BacktoBackArrays();
		int[] sortArray_0_1_2 = backtoBackArrays.sortArray_0_1_2(nums);
		for(int i : sortArray_0_1_2) System.out.println(i);
		//System.out.println(sortArray_0_1_2);
 		
	}
	

}
