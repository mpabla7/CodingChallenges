package IntegerPermutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations 
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * 
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * NOTE 1: 1 <= nums.length <= 6  &&  -10 <= nums[i] <= 10
 * NOTE 2: [1,2,-3,-4,5,6] has exactly 6! = 6*5*4*3*2*1 = 720 permutations! 
 * NOTE 3: Did this from scratch. study more efficient soln
 * NOTE 4: LOOK AT PIC FROM 02/06/2021 in your iphone for recursion tree
 * 
 * LC MEDIUM: https://leetcode.com/problems/permutations/
 * 
 * 
 * @author mandeeppabla
 *
 */
public class Solutrion {
	
	  private List<List<Integer>> result = new ArrayList<>();
	    private List<Integer> memo = new ArrayList<>();
	    
	    public List<List<Integer>> permute(int[] nums) {
	        
	        for(int i : nums) memo.add(i);
	        //swap(1,2, memo);
	        //for(int i : memo) System.out.print(" " + i);
	        result.add(memo);
	        permutation(memo, 0);
	        System.out.println(result.size() + " size");
	        return result;
	    }
	    
	    public void permutation(List<Integer> nums, int start) {
	        
	        // base case
	        if(start == nums.size()-1) {
	            
	             List<Integer> s = new ArrayList<>();
	             s.addAll(nums);
	             swap(0,start,s);
	             //boolean contains = true;
	            
	             if(!result.contains(s)) result.add(s);
	            
	             List<Integer> reverse = new ArrayList<>();
	             for(int i = s.size()-1; i >=0; i--) {
	                 reverse.add(s.get(i));
	             }
	            
	             if(!result.contains(reverse)){
	                 result.add(reverse);
	                 permutation(reverse, 0);
	             } 
	            
	             return;
	        }
	        
	        // more logic here
	         for(int i = start; i < nums.size()-1; i++) {
	             
	             List<Integer> s = new ArrayList<>();
	             s.addAll(nums);
	             
	             permutation(s, ++start);
	             swap(i,i+1,s);
	             permutation(s, start++);
	         }
	        
	    }
	    
	    public void swap(int i, int j, List<Integer> l) {
	        int temp = l.get(j);
	        l.set(j , l.get(i));
	        l.set(i, temp);
	    }
	    
	    // public int reverse(int num) {
	    //     int reversed = 0;
	    //     while(num != 0) {
	    //         int digit = num % 10;
	    //         reversed = reversed * 10 + digit;
	    //         num /= 10;
	    //     }
	    //     return reversed;
	    // }
}
