/*
 * @lc app=leetcode.cn id=22 lang=golang
 * @lcpr version=30204
 *
 * [22] 括号生成
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：回溯构造括号序列，记录已经使用的左括号和右括号数量。
// 关键点：左括号数量不超过 n，右括号数量不能超过左括号数量，才能保证前缀合法。
// 复杂度：时间和空间主要由答案数量决定，约为 O(C_n * n)。
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

