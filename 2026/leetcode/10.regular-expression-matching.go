/*
 * @lc app=leetcode.cn id=10 lang=golang
 * @lcpr version=30204
 *
 * [10] 正则表达式匹配
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func isMatch(s string, p string) bool {
	m, n := len(s)+1, len(p)+1
	ss, pp := []rune(s), []rune(p)
	dp := make([][]bool, m)
	for i := 0; i < m; i++ {
		dp[i] = make([]bool, n)
	}
	dp[0][0] = true
	for j := 2; j < n; j += 2 {
		dp[0][j] = dp[0][j-2] && pp[j-1] == '*'
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if pp[j-1] == '*' {
				dp[i][j] = dp[i][j-2] || dp[i-1][j] && (ss[i-1] == pp[j-2] || pp[j-2] == '.')
			} else {
				dp[i][j] = dp[i-1][j-1] && (ss[i-1] == pp[j-1] || pp[j-1] == '.')
			}
		}
	}
	return dp[m-1][n-1]

}

// @lc code=end

/*
// @lcpr case=start
// "aa"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "aa"\n"a*"\n
// @lcpr case=end

// @lcpr case=start
// "ab"\n".*"\n
// @lcpr case=end

*/

