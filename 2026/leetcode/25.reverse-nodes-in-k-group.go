/*
 * @lc app=leetcode.cn id=25 lang=golang
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

