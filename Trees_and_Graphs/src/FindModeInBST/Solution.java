package FindModeInBST;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import TreeNode.TreeNode;


/**
 *   501. Find Mode in Binary Search Tree
 *   https://leetcode.com/problems/find-mode-in-binary-search-tree/
 *   
 *   tHIS IS an inefficient/over complivated soln 
 * @author mandeeppabla
 *
 */
public class Solution {
	
	   // private ArrayList<Integer> list = new ArrayList<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root);
       // System.out.println(map);
        int index = 0;
        int max = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==max) {
                list.add(entry.getKey());
               // index++;
            }
        }
        int [] result = new int[list.size()];
        for(int i =0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
                return result;
    }
    
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);
        
        if(map.get(root.val) != null) {
           map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        
        inOrder(root.right);
    }

}
