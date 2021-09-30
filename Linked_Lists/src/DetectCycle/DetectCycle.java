package DetectCycle;
/*
 * Problem: 
 * https://leetcode.com/problems/linked-list-cycle/submissions/
 * 
 * Level:
 * Easy
 * 
 * Solve Time/Date:
 * 55 minutes 
 * 4/3/20
 * 
 * Note: I am just adding the nodes to a list (you can consider it a set). The list first 
 * checks if this value already exists, if so return true (meaning there is a cycle in linked list),
 * otherwise add the string representation of the memory location into the list.
 */
import java.util.ArrayList;

public class DetectCycle {
	
	public boolean hasCycle(ListNode head) {
	    
	    if(head==null) return false;
	    if(head.next == null) return false;
	    
	    ArrayList<String> list = new ArrayList<>();
	    ListNode cur = head;
	    while(cur != null) {
	    
	        if(list.contains(cur.toString())) return true;
	        else list.add(cur.toString());
	        
	        //System.out.println(cur.toString());
	        cur = cur.next;
	    }
	    //false = no cycle 
	    return false; 
	}
}

class ListNode {
	int val;
	ListNode next; 
	ListNode(int x) {val = x;}
}