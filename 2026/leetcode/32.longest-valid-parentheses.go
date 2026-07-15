/*
 * @lc app=leetcode.cn id=32 lang=golang
 * @lcpr version=30204
 *
 * [32] 最长有效括号
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
//
//	方法一、 栈
// func longestValidParentheses(s string) int {
// 	stack := []int{-1}
// 	max := 0
// 	for i := 0; i < len(s); i++ {
// 		if s[i] == '(' {
// 			stack = append(stack, i)
// 		} else {
// 			stack = stack[0 : len(stack)-1]
// 			if len(stack) == 0 {
// 				stack = append(stack, i)
// 			} else {
// 				x := i - stack[len(stack)-1]
// 				if x > max {
// 					max = x
// 				}
// 			}
// 		}
// 	}
// 	return max
// }

// 方法二：
func longestValidParentheses(s string) int {
	if len(s) < 2 {
		return 0
	}
	max := 0
	dp := make([]int, len(s))
	for i := 1; i < len(s); i++ {
		if s[i] == '(' {
			dp[i] = 0
			continue
		}
		if s[i-1] == '(' {
			dp[i] = 2
			if i >= 2 {
				dp[i] += dp[i-2]
			}
		} else {
			if i-dp[i-1]-1 >= 0 && s[i-dp[i-1]-1] == '(' {
				dp[i] = dp[i-1] + 2
				if i-dp[i-1]-2 >= 0 {
					dp[i] += dp[i-dp[i-1]-2]
				}
			}
		}
		if dp[i] > max {
			max = dp[i]
		}
	}
	return max
}

// @lc code=end

/*
// @lcpr case=start
// "(()"\n
// @lcpr case=end

// @lcpr case=start
// ")()())"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

*/

