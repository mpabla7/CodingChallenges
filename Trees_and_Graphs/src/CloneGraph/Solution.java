package CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	/**
	 * 
	 * 133. Clone Graph : https://leetcode.com/problems/clone-graph/
	 * GOOD SOLUTION
	 * 
	 * @param node
	 * @return
	 */
    public Node cloneGraph(Node node) {
        
        if(node==null) return node;
        
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>(); // map og to new nodes
        q.add(node);
        map.put(node, new Node(node.val));
        
        while(!q.isEmpty()) {
            
            Node curr = q.poll();
            
            for(Node n : curr.neighbors) {
                if(!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));

            }
            
        }
        
        return map.get(node);
        
        
    }
	
	/**
	 * 
	 * 133. Clone Graph : https://leetcode.com/problems/clone-graph/
	 * LC MEDIUM - 70 mins.
	 * BAD SOLUTION
	 * 
	 * @param node
	 * @return
	 */
	 public Node cloneGraphFromScratch(Node node) {
	        
	        if(node == null) return node;
	        else if(node.neighbors.size() == 0) return new Node(node.val);
	            
	        HashMap<Node, Node> map = new HashMap<>();
	        Queue<Node> q = new LinkedList<>();
	        q.add(node);
	        int size = q.size();
	        
	        while(!q.isEmpty()) {                
	                Node cur = q.poll();
	                if(cur != null ) {
	                    
	                    if(!map.containsKey(cur)) {
	                        map.put(cur, new Node(cur.val));
	                    }
	                    if(map.get(cur).neighbors.size()==0) {
	                        
	                        ArrayList<Node> list = new ArrayList<>();
	                        list.addAll(cur.neighbors);
	                        for(int i = 0; i < list.size(); i++) {                            
	                            if(!map.containsKey(list.get(i))) {
	                                map.put(list.get(i), new Node(list.get(i).val));
	                            }
	                            map.get(cur).neighbors.add(map.get(list.get(i)));
	                            q.add(cur.neighbors.get(i));
	                        }
	                    }
	                }
	        }
	        return map.get(node);
	    }
}
