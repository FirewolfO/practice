import "math"

/*
 * @lc app=leetcode.cn id=8 lang=golang
 * @lcpr version=30204
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func myAtoi(s string) int {
	i := 0
	ss := []rune(s)
	l := len(ss)
	for i < l && ss[i] == ' ' {
		i++
	}
	if i == l {
		return 0
	}
	flag := int64(1)
	if ss[i] == '+' || ss[i] == '-' {
		if ss[i] == '-' {
			flag = -1
		}
		i++
	}
	res := int64(0)
	for i < l {
		x := ss[i]
		if x > '9' || x < '0' {
			break
		}
		res = res*10 + int64(x-'0')
		if res > math.MaxInt32 && flag == 1 {
			return math.MaxInt32
		}
		if res > math.MaxInt32+1 && flag == -1 {
			return math.MinInt32
		}
		i++
	}
	return int(res * flag)
}

// @lc code=end

/*
// @lcpr case=start
// "42"\n
// @lcpr case=end

// @lcpr case=start
// " -042"\n
// @lcpr case=end

// @lcpr case=start
// "1337c0d3"\n
// @lcpr case=end

// @lcpr case=start
// "0-1"\n
// @lcpr case=end

// @lcpr case=start
// "words and 987"\n
// @lcpr case=end

*/

