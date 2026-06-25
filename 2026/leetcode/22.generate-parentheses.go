/*
 * @lc app=leetcode.cn id=22 lang=golang
 * @lcpr version=30204
 *
 * [22] 括号生成
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// func generateParenthesis(n int) []string {
// 	return backtracking([]string{}, 0, 0, n, "")
// }
// func backtracking(res []string, left, right, n int, str string) []string {
// 	if len(str) == 2*n {
// 		res = append(res, str)
// 		return res
// 	}

// 	if left < n {
// 		str = str + "("
// 		res = backtracking(res, left+1, right, n, str)
// 		str = str[:len(str)-1]
// 	}
// 	if left > right {
// 		str = str + ")"
// 		res = backtracking(res, left, right+1, n, str)
// 		str = str[:len(str)-1]
// 	}
// 	return res
// }

func generateParenthesis(n int) []string {
	res := make([]string, 0)
	backtracking(&res, 0, 0, n, "")
	return res
}
func backtracking(res *[]string, left, right, n int, str string) {
	if len(str) == 2*n {
		*res = append(*res, str)
		return
	}

	if left < n {
		str = str + "("
		backtracking(res, left+1, right, n, str)
		str = str[:len(str)-1]
	}
	if left > right {
		str = str + ")"
		backtracking(res, left, right+1, n, str)
		str = str[:len(str)-1]
	}
}

// @lc code=end

/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

*/

