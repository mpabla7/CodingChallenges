package MergeTwoSortedLists;
/*
 * Problem: 
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions/
 * 
 * Level: 
 * Easy
 * 
 * Solve Time/Date:
 * 30 minutes 
 * 4/3/20
 * 
 * Note: I have multiple solns submitted. Look at leetcode for more efficient slon
 */
public class MergeProblem {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null){
            return l1;
        }
       
        ListNode fullList = new ListNode(-1);
        ListNode ptr = fullList;
       
        while((l1!=null) && (l2!=null)) {
            
            if(l1.val <= l2.val){
                
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
                ptr = ptr.next;
                
            } else {
                
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
                ptr = ptr.next;
            }
        }
       
        if(l1==null){      
            while(l2!=null){          
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
                ptr = ptr.next;
            }       
        }else if(l2==null){        
           while(l1!=null){            
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
                ptr = ptr.next;
            }      
        }  
       return fullList.next;   
   }

}


class ListNode {
	int val;
	ListNode next; 
	ListNode(int x) {val = x;}
}
