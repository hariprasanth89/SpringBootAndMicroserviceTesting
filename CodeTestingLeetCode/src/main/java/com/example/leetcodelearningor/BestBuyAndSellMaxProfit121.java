package com.example.leetcodelearningor;

public class BestBuyAndSellMaxProfit121 {
	
	
	public static int maxProfit(int[] arr) {
		
		int length = arr.length;
		int maxProfitga = 0;
		int minProfitga = Integer.MAX_VALUE;
		
		if(length ==0) return 0;
		for (int i = 0; i < length; i++) {
				minProfitga = Math.min(minProfitga, arr[i]);
				maxProfitga = Math.max(maxProfitga, arr[i] - minProfitga);
		}
		return maxProfitga;
	}
	public static int maxProfitApproach(int[] arr) {

		int length = arr.length;
		int maxProfitga = 0;
		int minProfitga = Integer.MAX_VALUE;

		if (length == 0)
			return 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] < minProfitga) {
				minProfitga = arr[i];
			} else if (arr[i] - minProfitga > maxProfitga) {
				maxProfitga = arr[i] - minProfitga;
			}
		}
		return maxProfitga;
	}
	public static void main(String[] args) {
		int price[] = {7,1,5,3,6,4};
		int maxProfit = maxProfit(price);
		maxProfitApproach(price);
		System.out.println(maxProfit);
	}

}
