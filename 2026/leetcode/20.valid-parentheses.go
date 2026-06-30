/*
 * @lc app=leetcode.cn id=20 lang=golang
 * @lcpr version=30204
 *
 * [20] 有效的括号
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：用栈保存尚未匹配的左括号，遇到右括号时检查栈顶是否对应。
// 关键点：右括号到来时栈为空或类型不匹配都立即返回 false，最后栈必须为空。
// 复杂度：时间 O(n)，空间 O(n)。
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

