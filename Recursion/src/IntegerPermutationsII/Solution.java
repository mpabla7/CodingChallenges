package IntegerPermutationsII;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 47. Permutations II
 * 
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 * Input: nums = [1,1,2]
 * Output: [[1,1,2], [1,2,1], [2,1,1]]
 * 
 * NOTE1 : Did this from scratch. study more efficient soln. I only changed two line of code from IntegerPermutations
 * 
 * LC MEDIUM: https://leetcode.com/problems/permutations-ii/
 * 
 * @author mandeeppabla
 *
 */
public class Solution {
    
	   private  List<List<Integer>> result = new ArrayList<>();
	   private List<Integer> memo = new ArrayList<>();
	    
	   private int counter = 0;
	   public List<List<Integer>> permuteUnique(int[] nums) {
	        	for(int i : nums) memo.add(i);

		        result.add(memo);
		        permutation(memo, 0);
		        System.out.println(result.size() + " size " + "counter= " + counter);
		        return result;
	    }
	    
	     public void permutation(List<Integer> nums, int start) {
		        counter++;
	            
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
		             if(result.contains(s)) return;			// THIS LINE OF CODE MAKES IT MORE EFFICIENT
		             permutation(s, start++);
	                 
	                 if(result.contains(s)) return;			// THIS LINE OF CODE MAKES IT MORE EFFICIENT
		         }
		        
		    }
	    
	    public void swap(int i, int j, List<Integer> l) {
		        int temp = l.get(j);
		        l.set(j , l.get(i));
		        l.set(i, temp);
		}
	}