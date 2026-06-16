/*
 * @lc app=leetcode.cn id=14 lang=golang
 * @lcpr version=30204
 *
 * [14] 最长公共前缀
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func longestCommonPrefix(strs []string) string {
	i := 0
	for ; i < len(strs[0]); i++ {
		c := []rune(strs[0])[i]
		for j := 1; j < len(strs); j++ {
			if i >= len(strs[j]) || []rune(strs[j])[i] != c {
				return string([]rune(strs[0])[:i])
			}
		}
	}
	return string([]rune(strs[0])[:i])
}

// @lc code=end

/*
// @lcpr case=start
// ["flower","flow","flight"]\n
// @lcpr case=end

// @lcpr case=start
// ["dog","racecar","car"]\n
// @lcpr case=end

*/

