/*
 * @lc app=leetcode.cn id=14 lang=golang
 * @lcpr version=30204
 *
 * [14] 最长公共前缀
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：以第一个字符串为基准，逐列比较所有字符串的同一位置字符。
// 关键点：任一字符串结束或字符不相等时，当前位置之前就是最长公共前缀。
// 复杂度：时间 O(S)，空间 O(1)，S 为参与比较的字符总数。
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

