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
    public boolean isPalindrome(ListNode head) {
        
        List<Integer> li = new ArrayList<>();
        
        while (head != null) {
            li.add(head.val);
            head = head.next;
        }
        
        int right = li.size() - 1;
        int left = 0;
        
        while (left <= right) {
            if (li.get(left++) != li.get(right--)) return false;
        }
        
        return true;
        
    }
}
