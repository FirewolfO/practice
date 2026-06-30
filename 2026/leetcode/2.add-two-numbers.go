/*
 * @lc app=leetcode.cn id=2 lang=golang
 * @lcpr version=30204
 *
 * [2] 两数相加
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：按链表节点从低位到高位逐位相加，用 carry 保存进位。
// 关键点：循环条件包含 carry != 0，保证最高位进位也能生成新节点。
// 复杂度：时间 O(max(m,n))，空间 O(max(m,n)) 用于结果链表。
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	res := &ListNode{}
	tmp := res
	carry := 0
	for l1 != nil || l2 != nil || carry != 0 {
		sum := carry
		if l1 != nil {
			sum += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			sum += l2.Val
			l2 = l2.Next
		}
		tmp.Next = &ListNode{Val: sum % 10}
		carry = sum / 10
		tmp = tmp.Next
	}
	return res.Next
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

