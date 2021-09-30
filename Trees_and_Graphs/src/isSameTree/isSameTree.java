package isSameTree;

import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;

public class isSameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * (BAD EXAMPLE : HOW NOT DO TO)
	 * 100. Same Tree
	 * 
	 * Given two binary trees, write a function to check if they are the same or not.
	 *
	 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
	 * @param p TreeNode root
	 * @param q TreeNode root
	 * @return boolean - is it the same binary tree
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
	    
	    if(q == null && p == null) return true;
	    if(q == null || p == null) return false;
	    if(p.val != q.val) return false;
	    
	    Queue<TreeNode> q1 = new LinkedList<>();
	    Queue<TreeNode> q2 = new LinkedList<>();
	    q1.add(p);
	    q2.add(q);
	    int n1 = q1.size();
	    int n2 = q2.size();
	    
	    while(!q1.isEmpty() && !q2.isEmpty()) {
	        while(n1 > 0 && n2 > 0) {
	            
	            TreeNode cur1 = q1.remove();
	            TreeNode cur2 = q2.remove();
	            
	            if(cur1 == null && cur2 != null) return false;
	            if(cur1 != null && cur2 == null) return false;
	            if(cur1 !=null  && cur2 !=null ) {
	            	
	            	if(cur1.val != cur2.val) return false;
	            // we add the null's ... we don't just ignore cur2.left if it is == null.. need to keep track
	                q1.add(cur1.left);
	                q1.add(cur1.right);
	                q2.add(cur2.left);
	                q2.add(cur2.right);
	            }

	            n1--;
	            n2--;
	        }
	        n1 = q1.size();
	        n2 = q2.size();
	    } 
	    return true;
	}
	/**
	 * (GOOD EXAMPLE)
	 * 100. Same Tree
	 * 
	 * Given two binary trees, write a function to check if they are the same or not.
	 *
	 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
	 * @param p
	 * @param q
	 * @return
	 */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) return true;
        if(p != null && q != null) {
            if(p.val == q.val) {
                if(isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    /**
     * 100. Same Tree
     * redo 
     * did from scratch... took 26 mins
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        
        if(p == null && q == null) {
            return true;
        } else if(p == null || q == null) {
            return false;
        }
        
        boolean left = isSameTree(p.left , q.left);
        boolean right = isSameTree(p.right, q.right);
        
        if(p.val == q.val && left && right) return true;
        
        
        return false;
    }
    
    
    
    
    
    
    
	
	
	/**
	 * 572. Subtree of Another Tree 
	 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. 
	 * A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
	 * @param s
	 * @param t
	 * @return
	 */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        // a null tree is a sub-tree of any tree
        if(t == null) return true;
        if(s == null) return false;
        
        if(identical(s,t)) return true;
        
       return (isSubtree(s.left, t) || isSubtree(s.right, t)); 
    }
    
        public boolean identical(TreeNode s, TreeNode t) {
        
        if(s== null && t == null) return true;
        if(s != null && t != null) {
            if(s.val == t.val) {
               if( identical(s.left, t.left) && identical(s.right, t.right) ){
                    return true;
               }
            }
        }
        
        return false;
    }
    
        /**
         *  572. subtree of another tree
         *  redo 
         *  took 9 mins/... not the most efficient 
         */
        public boolean isSubtree2(TreeNode s, TreeNode t) {
            
            if(s != null && t == null) return true; //  The tree s could also be considered as a subtree of itself.
            else if (s == null && t != null) return false;
                
            // traverse the s tree
            Queue<TreeNode> q = new LinkedList<>();
            q.add(s);
            int size = q.size();
            int depth = 0;
                
            while(!q.isEmpty()) {
                while(size > 0) {
                    
                    TreeNode cur = q.remove();
                    if(isSameTree2(cur, t)) {
                        return true;
                    }
                    
                    if(cur.left != null) q.add(cur.left);
                    if(cur.right != null) q.add(cur.right);
                    size--;
                }
                depth+=1;
                size = q.size();
            }
            
                
            return false;
                
            }

}
