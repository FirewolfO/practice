/*
 * @lc app=leetcode.cn id=20 lang=golang
 * @lcpr version=30204
 *
 * [20] 有效的括号
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func isValid(s string) bool {
	m := map[rune]rune{
		']': '[',
		'}': '{',
		')': '(',
	}
	stack := make([]rune, 0)
	ss := []rune(s)
	for i := 0; i < len(ss); i++ {
		c := ss[i]
		if v, ok := m[c]; ok {
			if len(stack) == 0 {
				return false
			}
			x := stack[len(stack)-1:][0]
			if x != v {
				return false
			}
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, c)
		}
	}
	return len(stack) == 0
}

// @lc code=end

/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "()[]{}"\n
// @lcpr case=end

// @lcpr case=start
// "(]"\n
// @lcpr case=end

// @lcpr case=start
// "([])"\n
// @lcpr case=end

// @lcpr case=start
// "([)]"\n
// @lcpr case=end

*/

