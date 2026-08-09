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

class Solution {
    public void reorderList(ListNode head) {

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split the list
        ListNode second = slow.next;
        slow.next = null;

        // 3. Reverse second half
        ListNode prev = null;
        ListNode current = second;

        while (current != null) {
            ListNode next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }

        // 4. Merge/interleave
        ListNode first = head;
        second = prev;

        while (second != null) {

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}