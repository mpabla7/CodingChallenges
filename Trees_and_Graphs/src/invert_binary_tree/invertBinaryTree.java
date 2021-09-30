package invert_binary_tree;
import TreeNode.TreeNode;

public class invertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static TreeNode invertTree(TreeNode root) {
        
    	if (root == null) return root; 
    	TreeNode left = invertTree(root.left);
    	TreeNode right  = invertTree(root.right);
    	
    	root.left = right;
    	root.right = left;
    	
    	return root;
    }

}

/**
 * This was a redo... 
 * 
 * 7 mins
 * @author mandeeppabla
 *
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        invert(root);
        return root;
    }
    
    public TreeNode invert(TreeNode node) {
        
        if(node != null){
           TreeNode left = invert(node.left);
           TreeNode right = invert(node.right);
           
            node.right = left;
            node.left = right;
        }
        return node;
    }
}