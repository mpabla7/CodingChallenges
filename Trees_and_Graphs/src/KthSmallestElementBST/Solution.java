package KthSmallestElementBST;
import TreeNode.TreeNode;
import java.util.ArrayList;

/**
 * 230. Kth Smallest Element in a BST
 * 
 * 
 * LC medium 
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * @author mandeeppabla
 *
 */
public class Solution {
	 private ArrayList<Integer> cache = new ArrayList<>();
	    
	    public int kthSmallest(TreeNode root, int k) {
	        
	        if(root == null) return 0;
	        
	        inOrder(root);
	        //for(int i : cache) System.out.println(i);  
	        int result = cache.get(k-1);

	        return result;
	    }
	    
	    public void inOrder(TreeNode node) {
	        
	        if(node == null) return;
	        
	        //left, root, right
	        inOrder(node.left);
	        cache.add(node.val);
	        inOrder(node.right);
	    
	    }
}
