package Balanced_binary_tree;
import TreeNode.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [3,9,20,null,null,15,7]
		  //         3
		 //         / \
		 //       9   20
		 //      /   /  \
		 ///    10  15   7
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(10);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		
		System.out.println(isBalanced(root));

	}
	
	
/*
 *  		https://leetcode.com/problems/balanced-binary-tree/submissions/
 *  
 *  		https://www.youtube.com/watch?v=LU4fGD-fgJQ&ab_channel=BackToBackSWE
 * 			 https://www.youtube.com/watch?v=0grXyxUpJjs&feature=emb_title&ab_channel=CodingDecoded
 * 
 * 			This soln uses bottom up approach (recurrsion) dfs 
 * 			Note: there is a global variable that keeps track of balance 
 * 			Time Complexity: O(n) where n is the number of nodes 
 * 			
 */
    private static boolean isBalanced = true;
    public static boolean isBalanced(TreeNode root) {
       
        if(root == null) return true;
        depth(root);
        return isBalanced;
        
    }
    
    public static int depth(TreeNode root) {
        
        if(root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
      //  System.out.println("leftDepth = " + leftDepth);
      //  System.out.println("rightDepth = " + rightDepth);
        if(Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
            return -1;
        }
        
        int depth = Math.max(leftDepth, rightDepth) + 1;
     //   System.out.println("depth = " + depth);
     //   System.out.println("-----------------");
        return depth;

    }
}
