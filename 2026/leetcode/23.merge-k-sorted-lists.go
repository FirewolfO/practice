/*
 * @lc app=leetcode.cn id=23 lang=golang
 * @lcpr version=30204
 *
 * [23] 合并 K 个升序链表
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：分治合并 K 个有序链表，把区间拆成左右两半分别合并，再合并两个有序链表。
// 关键点：递归边界处理空区间和单链表区间，合并阶段复用原链表节点。
// 复杂度：时间 O(N log k)，空间 O(log k) 递归栈，N 为所有节点总数。
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeKLists(lists []*ListNode) *ListNode {
	return mergeK1Lists(lists, 0, len(lists)-1)
}

func mergeK1Lists(lists []*ListNode, start, end int) *ListNode {
	if start == end {
		return lists[start]
	}
	if start > end {
		return nil
	}
	mid := (start + end) / 2
	left := mergeK1Lists(lists, start, mid)
	right := mergeK1Lists(lists, mid+1, end)
	res := &ListNode{}
	tmp := res
	for left != nil && right != nil {
		if left.Val < right.Val {
			tmp.Next = left
			left = left.Next
		} else {
			tmp.Next = right
			right = right.Next
		}
		tmp = tmp.Next
	}
	if left != nil {
		tmp.Next = left
	}
	if right != nil {
		tmp.Next = right
	}
	return res.Next
}

// @lc code=end

/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

*/

