package deepest_leaves_sum;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import TreeNode.TreeNode;

public class Solution {
	
	
	 private HashMap<Integer, Integer> map = new HashMap<>();
	    // do a bfs and have a depth index
	    // memorize all of the nodes at the largest index
	    // take sum and return 
	 
	 /**
	  *  Given a binary tree, return the sum of values of its deepest leaves.
	  *   https://leetcode.com/problems/deepest-leaves-sum/
	  *   
	  *   LC medium 
	  * @param root
	  * @return
	  */
	    //O(3n) = O(n)????
	    public int deepestLeavesSum(TreeNode root) {
	        
	        bfs(root);
	        int result = 0;
	        int max = Collections.max(map.values());
	        
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if(entry.getValue() == max) {
	                result += entry.getKey();
	            }
	        }

	        return result;
	    }
	    // n =  # of nodes. O(n) 
	    public void bfs(TreeNode root) {
	        if(root == null) return;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        int size = q.size();
	        int depth = 0;
	        while(!q.isEmpty()) {    
	            while(size > 0) {   
	                TreeNode cur = q.remove();
	                map.put(cur.val, depth);
	                if(cur.left != null) q.add(cur.left);
	                if(cur.right != null) q.add(cur.right);
	                size--;
	            }
	            size = q.size();
	            depth++;    
	        }
	    }
//	    
//	    public int bfs(Tree root) {
//	    	
//	    	if(root == null) return;
//	    	Queue<Tree> q = new LinkedList<>();
//	    	q.add(root);
//	    	int size = q.size();
//	    	int depth = 0;
//	    	
//	    	while(!q.isEmpty()) {    
//	    		while(size > 0) {  
//	    			Tree cur = q.remove();
//	    			if(cur.right != nulßl) {
//	                      q.add(cur.right);
//	                }
//	                if(cur.left != null) {
//	                      q.add(cur.left);
//	                 }
//	    			size--;
//	    		}
//	    		 size = q.size();
//	    		 depth+=1;
//	    	}
//	    	return depth;
//	    }ß
}





