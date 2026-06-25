/*
 * @lc app=leetcode.cn id=24 lang=golang
 * @lcpr version=30204
 *
 * [24] 两两交换链表中的节点
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
func swapPairs(head *ListNode) *ListNode {
	res := &ListNode{Next: head}
	p := res
	for p.Next != nil && p.Next.Next != nil {
		tmp := p.Next
		p.Next = p.Next.Next
		tmp.Next = p.Next.Next
		p.Next.Next = tmp
		p = p.Next.Next
	}
	return res.Next
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

