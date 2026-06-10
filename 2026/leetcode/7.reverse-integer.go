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

