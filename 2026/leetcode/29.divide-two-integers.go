import "math"

/*
 * @lc app=leetcode.cn id=29 lang=golang
 * @lcpr version=30204
 *
 * [29] 两数相除
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func divide(dividend int, divisor int) int {
	dividendL := abs(int64(dividend))
	divisorL := abs(int64(divisor))
	divisorO := divisorL
	flag := 1
	if (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) {
		flag = -1
	}
	tmp := int64(1)
	for dividendL >= divisorL+divisorL {
		tmp <<= 1
		divisorL <<= 1
	}
	res := int64(0)
	for dividendL >= divisorO {
		if dividendL >= divisorL {
			dividendL -= divisorL
			res += tmp
		}
		tmp >>= 1
		divisorL >>= 1
	}
	if res > math.MaxInt32 && flag == 1 {
		return math.MaxInt32
	}
	return int(res) * flag
}

func abs(val int64) int64 {
	if val < 0 {
		return -1 * val
	}
	return val
}

// @lc code=end

/*
// @lcpr case=start
// 10\n3\n
// @lcpr case=end

// @lcpr case=start
// 7\n-3\n
// @lcpr case=end

*/

