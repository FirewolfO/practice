/*
 * @lc app=leetcode.cn id=9 lang=golang
 * @lcpr version=30204
 *
 * [9] 回文数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：反转整数后与原数比较，判断十进制表示是否前后对称。
// 关键点：负数直接不是回文，反转时按位取模和整除推进。
// 复杂度：时间 O(log n)，空间 O(1)。
func isPalindrome(x int) bool {
	if x < 0 || x%10 == 0 && x != 0 {
		return false
	}
	y := 0
	for x > y {
		y = y*10 + x%10
		x = x / 10
	}
	return x == y || x == y/10
}

// @lc code=end

/*
// @lcpr case=start
// 121\n
// @lcpr case=end

// @lcpr case=start
// -121\n
// @lcpr case=end

// @lcpr case=start
// 10\n
// @lcpr case=end

*/

