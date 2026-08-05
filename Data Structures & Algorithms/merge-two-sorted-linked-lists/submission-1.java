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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail= null;
        while(list1!=null&&list2!=null){
            ListNode node;
            if(list1.val<=list2.val){
                node= list1;
                list1=list1.next;
            }else{node=list2;list2=list2.next;}
            if(head==null){head = node;
            tail=node;}else{tail.next=node;tail=tail.next;}
        }if(head==null){return (list1 !=null)? list1:list2;}
        if(list1!=null){tail.next=list1;}
        else{tail.next=list2;}return head;
    }
}