package Longest_Common_Subsequence;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	/**
	 * 1143. Longest Common Subsequence: https://leetcode.com/problems/longest-common-subsequence/
	 * 
	 * Given two strings text1 and text2, return the length of their longest common subsequence.
	 * 
	 * LC Medium - 41 mins
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
public int longestCommonSubsequence(String text1, String text2) {
        
        int rows = text1.length();
        int cols = text2.length();
        boolean text1Larger = false;
            
        if(text1.length() > text2.length() ) {
            rows = text2.length();
            cols = text1.length();
            text1Larger = true;
        }
        
        int [][] m = new int[rows+1][cols+1];
        char first;
        char second;
        
        for(int i = 1; i < m.length; i++) {
            for(int j = 1; j < m[i].length; j++) {
                //System.out.print("[" + i + "," + j + "]");
                if(text1Larger) {
                    second = text1.charAt(j-1);
                    first = text2.charAt(i-1);                    
                } else {
                    first = text1.charAt(i-1);
                    second = text2.charAt(j-1);
                }
                
                if(second == first) {
                    m[i][j] = m[i-1][j-1] + 1;
                } else if(second != first) {
                    m[i][j] = Math.max(m[i-1][j], m[i][j-1]);
                }
            }
            //System.out.println();
        }
   
        return m[rows][cols];
    }
}
