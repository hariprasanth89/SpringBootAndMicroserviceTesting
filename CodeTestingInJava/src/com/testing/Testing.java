package com.testing;

public class Testing {
	
	public static void sortColors(int[] nums) {
		int len = nums.length;
		int zero = 0, one = 0, two = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) {
				zero++;
			} else if (nums[i] == 1) {
				one++;
			} else {
				two++;
			}
		}
		for (int i = 0; i < zero; i++) {
			nums[i] = 0;
		}
		for (int i = zero; i < zero + one; i++) {
			nums[i] = 1;
		}
		for (int i = zero + one; i < len; i++) {
			nums[i] = 2;
		}
	}
	
	
	public static void main(String[] args) {
		int nums = 1;
		int[] nums1 = {0,1,2,4,5,6};
		sortColors(nums1);
	}

}
