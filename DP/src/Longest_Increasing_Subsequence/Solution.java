package Longest_Increasing_Subsequence;

public class Solution {
	
	/**
	 * 300. Longest Increasing Subsequence
	 *
	 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
	 *
	 * A subsequence is a sequence that can be derived from an array by deleting some or no elements 
	 * without changing the order of the remaining elements.
	 * 
	 * https://leetcode.com/problems/longest-increasing-subsequence/
	 * 
	 * @param nums - integer array
	 * @return maxans - integer length of the longest strictly increasing subsequence
	 */
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 1) return 1;
        int [] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        
        for(int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
        
    }

}
