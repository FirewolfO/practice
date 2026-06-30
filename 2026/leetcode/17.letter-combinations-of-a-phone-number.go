/*
 * @lc app=leetcode.cn id=17 lang=golang
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：把每个数字映射到候选字母，递归/回溯拼接每一位的所有组合。
// 关键点：递归到末尾时返回空串作为拼接基底，再逐层组合当前字符和后续结果。
// 复杂度：时间 O(4^n * n)，空间 O(4^n * n) 用于结果集。
func letterCombinations(digits string) []string {
	mm := map[rune][]string{
		'2': {"a", "b", "c"},
		'3': {"d", "e", "f"},
		'4': {"g", "h", "i"},
		'5': {"j", "k", "l"},
		'6': {"m", "n", "o"},
		'7': {"p", "q", "r", "s"},
		'8': {"t", "u", "v"},
		'9': {"w", "x", "y", "z"},
	}
	return letterCombinationsWithIndex(mm, []rune(digits), 0)
}
func letterCombinationsWithIndex(mm map[rune][]string, digits []rune, index int) []string {
	if index == len(digits) {
		return []string{""}
	}
	res := make([]string, 0)
	ss := mm[digits[index]]
	next := letterCombinationsWithIndex(mm, digits, index+1)
	for i := 0; i < len(ss); i++ {
		o := ss[i]
		for j := 0; j < len(next); j++ {
			res = append(res, o+next[j])
		}
	}
	return res
}

// @lc code=end

/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

*/

