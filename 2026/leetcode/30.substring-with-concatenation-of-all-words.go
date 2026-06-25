/*
 * @lc app=leetcode.cn id=30 lang=golang
 * @lcpr version=30204
 *
 * [30] 串联所有单词的子串
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func findSubstring(s string, words []string) []int {
	m := map[string]int{}
	for i := 0; i < len(words); i++ {
		m[words[i]] = m[words[i]] + 1
	}
	res := make([]int, 0)
	wordLen := len(words[0])
	for i := 0; i < wordLen; i++ {
		left := i
		count := 0
		window := map[string]int{}
		for right := i; right+wordLen <= len(s); right += wordLen {
			word := s[right : right+wordLen]
			if _, ok := m[word]; !ok {
				count = 0
				window = make(map[string]int, 0)
				left = right + wordLen
				continue
			}
			window[word] = window[word] + 1
			count++
			for window[word] > m[word] {
				leftWord := s[left : left+wordLen]
				count--
				window[leftWord] = window[leftWord] - 1
				left += wordLen
			}
			if count == len(words) {
				res = append(res, left)
				leftWord := s[left : left+wordLen]
				window[leftWord] = window[leftWord] - 1
				left += wordLen
				count--
			}
		}
	}
	return res
}

// @lc code=end

/*
// @lcpr case=start
// "barfoothefoobarman"\n["foo","bar"]\n
// @lcpr case=end

// @lcpr case=start
// "wordgoodgoodgoodbestword"\n["word","good","best","word"]\n
// @lcpr case=end

// @lcpr case=start
// "barfoofoobarthefoobarman"\n["bar","foo","the"]\n
// @lcpr case=end

*/

