package BinaryTreeLevelOrderTraversal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TreeNode.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// [3,9,20,null,null,15,7]
	  //         3
	 //         / \
	 //        9  20
	 //          /  \
	 ///        15   7
	 //         /
	  //       12
  //          /  \
  //         2   4
		        
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.left.left = new TreeNode(12);
		root.right.left.left.left = new TreeNode(2);
		root.right.left.left.right = new TreeNode(4);
		
		//levelOrder(root);
		ArrayList<LinkedList<TreeNode>> list = listOfDepths(root);
		
		int index = -1;
		for(LinkedList<TreeNode> l : list) {
			index++;
			System.out.print("list " + index + ": ");
			for(int i =0; i < l.size(); i++) {
				TreeNode v = (TreeNode) l.get(i);
				System.out.print(v.val + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 102. Binary Tree Level Order Traversal   (medium)
	 * 
	 * @param root
	 * @return
	 */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	int n = q.size();
    	
    	while(!q.isEmpty()) {
    		List<Integer> temp = new ArrayList<>();
    		while(n > 0) {
    			TreeNode cur = q.remove();
    			if(cur!= null){ 
                    temp.add(cur.val);
    			    if(cur.right != null ) q.add(cur.right);
    			    if(cur.left != null) q.add(cur.left);
                 }
    			n--;
    		}
    		n = q.size();
            Collections.reverse(temp);
    		list.add(temp);
    	}
    	return list;
    }
    //CTCI: 4.3 List of Depths
    public static ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
		
    	if(root == null) return new ArrayList<LinkedList<TreeNode>>();
    	ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	int n = q.size();
    	
    	while(!q.isEmpty()) {
    		LinkedList<TreeNode> temp = new LinkedList<TreeNode>();
    		while(n > 0) {
    			TreeNode cur = q.remove();
    			if(cur.right != null) q.add(cur.right);
    			if(cur.left != null) q.add(cur.left);
    			temp.add(cur);
    			n--;
    		}
    		Collections.reverse(temp);
    		list.add(temp);
    		n = q.size();
    	}
     	
    	return list;
    }

}
