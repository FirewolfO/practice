/*
 * @lc app=leetcode.cn id=3 lang=golang
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func lengthOfLongestSubstring(s string) int {
	ss := []rune(s)
	m := map[rune]bool{}
	maxLen := 0
	left := 0
	right := 0
	for ; right < len(ss); right++ {
		for left < right && m[ss[right]] {
			delete(m, ss[left])
			left++
		}
		if right-left+1 > maxLen {
			maxLen = right - left + 1
		}
		m[ss[right]] = true
	}
	return maxLen
}

// @lc code=end

/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

*/

