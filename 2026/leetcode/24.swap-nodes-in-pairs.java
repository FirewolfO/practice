/*
 * @lc app=leetcode.cn id=24 lang=java
 * @lcpr version=30204
 *
 * [24] 两两交换链表中的节点
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：使用虚拟头节点，每次取相邻两个节点并调整指针完成交换。
// 关键点：交换后前驱指针移动到这一组的尾节点，继续处理下一组。
// 复杂度：时间 O(n)，空间 O(1)。
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
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode p = res;

        while(p.next != null && p.next.next != null){
            ListNode tmp = p.next;
            p.next = p.next.next;
            tmp.next = p.next.next;
            p.next.next = tmp;
            p = p.next.next;
        }
        return res.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

