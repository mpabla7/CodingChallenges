package MergekSortedLists;

import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0 || lists == null) return null;
        else {
            // int allEmpty = 0;
            // for(int i =0; i < lists.length; i++) {
            //     if(lists[i]
            // }
        } 
        
        ArrayList<ListNode> pointers = new ArrayList<>();
        ListNode head = new ListNode(-2);
        ListNode curr = head;
        
        for(int i =0; i < lists.length; i++) {
            if(lists[i] != null) {
               pointers.add(lists[i]);
            }
        }
        
        while(pointers.size() > 1) {
            
            ArrayList<Integer> vals = new ArrayList<>();
            for(int i =0; i < pointers.size(); i++) {
              //  if(pointers.get(i) != null) {
                     vals.add(pointers.get(i).val);
              //  }
            }
            
            int min = vals.get(0);
            int indexOfPtr = 0;
            for(int i =1; i < vals.size(); i++) {
                if(vals.get(i) < min) {
                    min = vals.get(i);
                    indexOfPtr = i;
                }
            }
            
            curr.next = new ListNode(min);
            curr = curr.next;
            
            ListNode here = pointers.get(indexOfPtr);
            if(here.next == null) {
                pointers.remove(here);
            } else {
                ListNode temp = here.next;
                pointers.set(indexOfPtr, temp);
            }
            
        }
        
        // add the rest of the nodes
        if(pointers.size() == 1) {
             ListNode temp = pointers.get(0);
            // ListNode c = temp;
             while(temp != null) {
                 curr.next = new ListNode(temp.val);
                 curr = curr.next;
                 temp = temp.next;
             }
            
        }
        
        return head.next;
    }
}
class ListNode {
	int val;
	ListNode next; 
	ListNode(int x) {val = x;}
}