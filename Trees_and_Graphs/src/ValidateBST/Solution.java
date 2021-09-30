package ValidateBST;
import java.util.ArrayList;

import TreeNode.TreeNode;

/**
 * 98. Validate Binary Search Tree (LC MEDIUM)
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/
 * @author mandeeppabla
 *
 */
public class Solution {
    private ArrayList<Integer> list = new ArrayList<Integer>();
    
    public boolean isValidBST(TreeNode root) {
        //  Other approach to solve this problem would be to use inorder traversal  (left, root, right)
       /// properties where previous element in output would  
        // always be lesser than the current output.
        inOrder(root);  
        return isSorted(list);
    }
    
    public boolean isSorted(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i) >= array.get(i+1))
                return false;
        }      return true;
    }
     
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
