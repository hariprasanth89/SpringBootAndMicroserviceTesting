package com.example.leetcodelearningor;

public class MedianOffTwoSortedArrays4 {

	static int getMedian(int ar1[], int ar2[]) {
		
		int lengthOfArr1 = ar1.length;
		int lengthOfArr2 = ar2.length;

// Current index of input array ar1[]
		int i = 0;

// Current index of input array ar2[]
		int j = 0;
		int count;
		int m1 = -1, m2 = -1;

// Since there are (n+m) elements, 
// There are following two cases 
// if n+m is odd then the middle 
//index is median i.e. (m+n)/2 
		int arr1AndArr2Both = lengthOfArr1 + lengthOfArr2;
		
		if ((lengthOfArr2 + lengthOfArr1) % 2 == 1) {
			for (count = 0; count <= arr1AndArr2Both / 2; count++) {
				if (i != lengthOfArr1 && j != lengthOfArr2) {
					m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
				} else if (i < lengthOfArr1) {
					m1 = ar1[i++];
				}

				// for case when j<m,
				else {
					m1 = ar2[j++];
				}
			}
			return m1;
		}

// median will be average of elements
// at index ((m+n)/2 - 1) and (m+n)/2
// in the array obtained after merging
// ar1 and ar2
		else {
			for (count = 0; count <= arr1AndArr2Both / 2; count++) {
				m2 = m1;
				if (i != lengthOfArr1 && j != lengthOfArr2) {
					m1 = (ar1[i] > ar2[j]) ? ar2[j++] : ar1[i++];
				} else if (i < lengthOfArr1) {
					m1 = ar1[i++];
				}

				// for case when j<m,
				else {
					m1 = ar2[j++];
				}
			}
			return (m1 + m2) / 2;
		}
	}
	

	public static void main(String[] args) {

		int ar1[] = { 900 };
	    int ar2[] = { 5, 8, 10, 20 };
	 
	    System.out.println(getMedian(ar1, ar2));
	    
	}

}
