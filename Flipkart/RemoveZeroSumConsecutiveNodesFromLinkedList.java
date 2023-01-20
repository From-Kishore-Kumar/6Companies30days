package Flipkart;
//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
//leetcode problem 1171
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
import java.util.*;
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        int prefix = 0;
        Map<Integer, ListNode> prefixToNode = new HashMap<>();
        prefixToNode.put(0, dummy);
      
        for (; head != null; head = head.next) {
            prefix += head.val;
            prefixToNode.put(prefix, head);
        }
      
        prefix = 0;
      
        for (head = dummy; head != null; head = head.next) {
            prefix += head.val;
            head.next = prefixToNode.get(prefix).next;
        }
      
        return dummy.next;
    }
      
}
