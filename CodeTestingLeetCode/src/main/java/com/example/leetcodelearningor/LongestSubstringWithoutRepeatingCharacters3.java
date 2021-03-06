package com.example.leetcodelearningor;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters3 {
	
	//Sliding Window approach
	
	public int lengthOfLongestSubstring(String s) {
		
		int length = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int j = 0, i = 0; j < length; j++) {
			if (map.containsKey(s.charAt(j))) {
				System.out.println(map.toString()   + "    " +  " i  "+i     +   "      "  + " j " + j );
				i = Math.max(map.get(s.charAt(j)), i);
				System.out.println(map.get(s.charAt(j)));
			}
			ans = Math.max(ans, j - i +1);
			System.out.println("ans"+ "   " +ans   +  "   " + i);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	}
	
	public int lengthOfLongestSubstring2ndApproach(String s) {
        int len = s.length();

        int res = 0;
        for (int i = 0; i < len; i++) {
        	System.out.println(i +"    " + "iiiii" );
            for (int j = i; j < len; j++) {
            	System.out.println( j + "   " +  " j");
                if (checkRepetition(s, i, j)) {
                	System.out.println("ifcondition inside");
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
	
	
    private boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            int sa = chars[c]++;
            System.out.println(c + "  " + sa  + "    " +i);
            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }
    
    
    public static void main(String[] args) {
    	String input = "abcabcbb";
    	LongestSubstringWithoutRepeatingCharacters3 longestSubstringWithoutRepeatingCharacters = new  LongestSubstringWithoutRepeatingCharacters3();
    	//longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring2ndApproach(input);
    	longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
	}

}
