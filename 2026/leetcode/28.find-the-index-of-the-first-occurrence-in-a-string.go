/*
 * @lc app=leetcode.cn id=28 lang=golang
 * @lcpr version=30204
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func strStr(haystack string, needle string) int {
	l := len(needle)
	for i := 0; i <= len(haystack)-l; i++ {
		sub := haystack[i : i+l]
		if sub == needle {
			return i
		}
	}
	return -1
}

// @lc code=end

/*
// @lcpr case=start
// "sadbutsad"\n"sad"\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n"leeto"\n
// @lcpr case=end

*/

