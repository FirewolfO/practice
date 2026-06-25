/*
 * @lc app=leetcode.cn id=25 lang=golang
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
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
func reverseKGroup(head *ListNode, k int) *ListNode {
	res := &ListNode{Next: head}
	p := res
	for p != nil {
		end := p
		count := 0
		for count < k && end != nil {
			end = end.Next
			count++
		}
		if end == nil {
			break
		}
		tmp := end.Next
		start := p.Next
		end.Next = nil
		rev := reverse(start)
		p.Next = rev
		start.Next = tmp
		p = start
	}
	return res.Next
}

func reverse(head *ListNode) *ListNode {
	var res *ListNode
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = res
		res = curr
		curr = next
	}
	return res
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

