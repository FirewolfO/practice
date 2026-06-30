import "math"

/*
 * @lc app=leetcode.cn id=7 lang=golang
 * @lcpr version=30204
 *
 * [7] 整数反转
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：不断取出 x 的末位数字，累加到反转结果 res 中。
// 关键点：每次乘 10 前先判断是否会超出 32 位有符号整数范围。
// 复杂度：时间 O(log|x|)，空间 O(1)。
func reverse(x int) int {
	res := 0
	for x != 0 {
		digit := x % 10
		if res > math.MaxInt32/10 || (res == math.MaxInt32/10 && digit > 7) {
			return 0
		}
		if res < math.MinInt32/10 || (res == math.MinInt32/10 && digit < -8) {
			return 0
		}
		res = res*10 + digit
		x = x / 10
	}
	return res
}

// @lc code=end

/*
// @lcpr case=start
// 123\n
// @lcpr case=end

// @lcpr case=start
// -123\n
// @lcpr case=end

// @lcpr case=start
// 120\n
// @lcpr case=end

// @lcpr case=start
// 0\n
// @lcpr case=end

*/

