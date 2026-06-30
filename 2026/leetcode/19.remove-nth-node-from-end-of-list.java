/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30204
 *
 * [19] 删除链表的倒数第 N 个结点
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：快慢指针保持 n 个节点的间距，快指针到尾时慢指针定位待删除节点前驱。
// 关键点：虚拟头节点可以统一处理删除头节点的场景。
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0,head);
        tmp.next = head;
        ListNode fast = tmp;
        ListNode slow = tmp;
        int count = 0; 
        while (count < n+1 && fast != null) {
            count++;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next != null){
            slow.next = slow.next.next;
        }
        return tmp.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n
// @lcpr case=end

 */

