/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：每次检查后面是否有完整 k 个节点，有则断开这一段、反转、再接回原链表。
// 关键点：不足 k 个节点时保持原顺序；反转后原段首会变成段尾，用它连接下一段。
// 复杂度：时间 O(n)，空间 O(1) 额外空间。
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode p = res;
        while(p != null){
            ListNode end = p;
            int i = 0;
            while(i<k && end != null){
                end = end.next;
                i++;
            }
           if(end == null){
                break;
           }
           ListNode tmp = end.next;
           ListNode start = p.next; 
           end.next = null;
           ListNode rev = reverse(start);
           p.next = rev;
           start.next = tmp; 
           p = start;
        }
        return res.next;
    }

    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode p = head;
        while(p != null){
            ListNode tmp = p.next;
            p.next = prev;
            prev = p;
            p = tmp;
        }
        return prev;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n3\n
// @lcpr case=end

 */

