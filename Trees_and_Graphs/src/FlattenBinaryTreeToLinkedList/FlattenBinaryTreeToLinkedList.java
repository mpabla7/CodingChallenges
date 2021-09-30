package FlattenBinaryTreeToLinkedList;
import java.util.LinkedList;

import TreeNode.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	     1
//	    / \
//	   2   5
//	  / \   \
//	 3   4   6
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		flatten(root);
		
		while(root != null) {
			System.out.println(root.val);
			root = root.right;
		}
		
	}
	
//The flattened tree should look like: 
//	1
//	 \
//	  2
//	   \
//	    3
//	     \
//	      4
//	       \
//	        5
//	         \
//	          6
	/**
	 * 114. Flatten Binary Tree to Linked List
	 * 
	 * Given a binary tree, flatten it to a linked list in-place.
	 * @param root
	 */
    public static void flatten(TreeNode root) {
        // pre-order: root, left, rigth
    	search(root);
    }
    
    public static void search(TreeNode node) {
    	// return if node is null or leaf node
    	if(node == null || (node.left == null && node.right == null)) return;
    	
    	//System.out.println(node.val);
    	search(node.left);
    	
    	if(node.left != null) {
    		
    		TreeNode temp = node.right;
    		node.right = node.left;
    		node.left = null;
    		
    		TreeNode cur = node.right;
    		while(cur.right != null) {
    			cur = cur.right;
    		}
    		cur.right = temp;
    	}
    	
    	search(node.right);
    	
    	
    	
    }
    
    /**
     * 114. Flatten Binary Treee
     * 
     * re did this. This took 17 mins. Inefficent, 
     */
    class Solution {
        
        private LinkedList<TreeNode> list = new LinkedList<>();
        
        public void flatten(TreeNode root) {
            
            if(root == null) return; 
            
            memorize(root);
            root.left = null;
            root.right = null;
            TreeNode cur = root;
            
            for(int i =1; i < list.size(); i++) {
                cur.right = list.get(i);
                cur.left = null;
                cur = cur.right;
            }
        }
        
        public void memorize(TreeNode root){
            if(root == null) return;
            list.add(root);
            memorize(root.left);
            memorize(root.right);
            
        }
    }

}
