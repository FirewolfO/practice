/*
 * @lc app=leetcode.cn id=19 lang=golang
 * @lcpr version=30204
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
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

