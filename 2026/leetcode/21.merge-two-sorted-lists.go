/*
 * @lc app=leetcode.cn id=21 lang=golang
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
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	res := &ListNode{}
	tmp := res
	for list1 != nil && list2 != nil {
		if list1.Val < list2.Val {
			tmp.Next = list1
			list1 = list1.Next
		} else {
			tmp.Next = list2
			list2 = list2.Next
		}
		tmp = tmp.Next
	}
	if list1 != nil {
		tmp.Next = list1
	}
	if list2 != nil {
		tmp.Next = list2
	}
	return res.Next
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

