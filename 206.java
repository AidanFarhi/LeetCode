/**
 * 206. Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 // Recursive solution
class RecursiveSolution {

    public ListNode reverseList(ListNode head) {
        return recurse(null, head);
    }
    
    public ListNode recurse(ListNode prev, ListNode current) {
        if (current == null) return current;
        ListNode next = current.next;
        current.next = prev;
        if (next == null) return current;
        return recurse(current, next);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}