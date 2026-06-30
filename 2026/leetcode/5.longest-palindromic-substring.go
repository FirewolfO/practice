/*
 * @lc app=leetcode.cn id=5 lang=golang
 * @lcpr version=30204
 *
 * [5] 最长回文子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：枚举每个字符作为回文中心，分别向两侧扩展奇数和偶数长度回文。
// 关键点：扩展结束后返回真实边界，并用最长边界截取答案。
// 复杂度：时间 O(n^2)，空间 O(n) 或 O(1)，取决于语言中的字符串切片/字符数组。
func longestPalindrome(s string) string {
	if len(s) == 0 {
		return ""
	}
	ss := []rune(s)
	start, end, max := 0, 0, 0
	for i := 0; i < len(ss); i++ {
		left, right := longest(i, i, ss)
		if right-left+1 > max {
			max = right - left + 1
			start = left
			end = right
		}

		left, right = longest(i, i+1, ss)
		if right-left+1 > max {
			max = right - left + 1
			start = left
			end = right
		}
	}
	return string(ss[start : end+1])
}

func longest(left, right int, ss []rune) (int, int) {
	for left >= 0 && right < len(ss) && ss[left] == ss[right] {
		left--
		right++
	}
	return left + 1, right - 1
}

// @lc code=end

/*
// @lcpr case=start
// "babad"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

*/

