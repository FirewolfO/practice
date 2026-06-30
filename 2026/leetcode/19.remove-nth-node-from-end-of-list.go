/*
 * @lc app=leetcode.cn id=19 lang=golang
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
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
	tmp := &ListNode{Next: head}
	slow, fast := tmp, tmp
	count := 0
	for count < n+1 && fast != nil {
		fast = fast.Next
		count++
	}
	for fast != nil {
		slow = slow.Next
		fast = fast.Next
	}
	if slow.Next != nil {
		slow.Next = slow.Next.Next
	}
	return tmp.Next
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

