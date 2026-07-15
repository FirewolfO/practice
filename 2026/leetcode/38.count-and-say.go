import "strconv"

/*
 * @lc app=leetcode.cn id=38 lang=golang
 * @lcpr version=30204
 *
 * [38] 外观数列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func countAndSay(n int) string {
	if n == 1 {
		return "1"
	}
	s := countAndSay(n - 1)
	c := s[0]
	count := 1
	res := ""
	for i := 1; i < len(s); i++ {
		if s[i] == c {
			count++
		} else {
			res = res + strconv.Itoa(count) + string(c)
			count = 1
			c = s[i]
		}
	}
	res = res + strconv.Itoa(count) + string(c)
	return res
}

// @lc code=end

/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

*/

