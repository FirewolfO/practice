/*
 * @lc app=leetcode.cn id=5 lang=golang
 * @lcpr version=30204
 *
 * [5] 最长回文子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
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

