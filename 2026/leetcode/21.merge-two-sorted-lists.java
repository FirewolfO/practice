/*
 * @lc app=leetcode.cn id=21 lang=java
 * @lcpr version=30204
 *
 * [21] 合并两个有序链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：用双指针依次比较两个有序链表的当前节点，把较小节点接到结果链表后面。
// 关键点：虚拟头节点简化头部连接，循环结束后直接接上未遍历完的链表。
// 复杂度：时间 O(m+n)，空间 O(1) 额外空间。
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
        ListNode res = new ListNode();
        ListNode tmp = res ;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tmp.next = list1;
                list1 = list1.next;
            }else{
                tmp.next = list2;
                list2 = list2.next;
            }
            tmp = tmp.next;
        }
        if(list1 != null){
            tmp.next = list1;
        }
        if(list2 != null){
            tmp.next = list2;
        }
        return res.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,4]\n[1,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n[]\n
// @lcpr case=end

// @lcpr case=start
// []\n[0]\n
// @lcpr case=end

 */

