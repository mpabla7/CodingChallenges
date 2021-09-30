package Longest_Consecutive_Sequence;

import java.util.Arrays;

public class Solution {
	
	/*
	 * 128. Longest Consecutive Sequence 
	 * LC HARD : https://leetcode.com/problems/longest-consecutive-sequence/
	 * 
	 * 
	 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     *
     * Input: nums = [0,3,7,2,5,8,4,6,0,1]
	 * Output: 9
	 * 
	 * Input: nums = [100,4,200,1,3,2]
	 * Output: 4
	 * 
	 * Input: nums = [9,1,4,7,3,-1,0,5,8,-1, 1, 2, 3, 4, 5 ,6, 7, 8,-1,6]
	 * Output: 11
	 * 
	 * ^^ sorted : -1 -1 -1 0 1 1 2 3 3 4 4 5 5 6 6 7 7 8 8 9
	 *
	 */
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 1) return 1;
        if(nums.length == 0) return 0;
        
        Arrays.sort(nums);
        int currentStreak = 1;
        int maxStreak = 1;
        
        //for(int i : nums) System.out.print(" " + i);
        
        for(int i =1; i < nums.length; i++) {
            
            if(nums[i-1]!=nums[i]) {
                if(nums[i-1] + 1 == nums[i]) { // is there a diff of 1?
                    
                    currentStreak+=1;
                } else {
                    maxStreak = Math.max(maxStreak, currentStreak);
                    currentStreak = 1;
                }
            }
            
        }
        //System.out.println("max = " + maxStreak + " cur = " + currentStreak);
        return Math.max(maxStreak, currentStreak);
    }
}
