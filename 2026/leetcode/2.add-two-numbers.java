/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30204
 *
 * [2] 两数相加
 */

// @lc code=start
// 核心思路：按链表节点从低位到高位逐位相加，用 carry 保存进位。
// 关键点：循环条件包含 carry != 0，保证最高位进位也能生成新节点。
// 复杂度：时间 O(max(m,n))，空间 O(max(m,n)) 用于结果链表。
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0 ;
        ListNode res = new ListNode();
        ListNode tmp = res;
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode(sum%10);
            carry = sum / 10;
            tmp = tmp.next;
        }
        return res.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

// @lcpr case=start
// [9,9,9,9,9,9,9]\n[9,9,9,9]\n
// @lcpr case=end

 */

