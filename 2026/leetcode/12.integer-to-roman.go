/*
 * @lc app=leetcode.cn id=12 lang=golang
 * @lcpr version=30204
 *
 * [12] 整数转罗马数字
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func intToRoman(num int) string {
	nums10 := []int{1000, 100, 10, 1}
	fuhao10 := []rune{'M', 'C', 'X', 'I'}
	fuhao5 := []rune{'D', 'L', 'V'}
	res := make([]rune, 0)
	for i := 0; num != 0 && i < len(nums10); i++ {
		count := num / nums10[i]
		num = num - count*nums10[i]
		if count == 0 {
			continue
		}
		if i == 0 {
			for j := 0; j < count; j++ {
				res = append(res, fuhao10[i])
			}
			continue
		}
		if count == 5 {
			res = append(res, fuhao5[i-1])
		} else if count == 4 {
			res = append(res, fuhao10[i], fuhao5[i-1])
		} else if count == 9 {
			res = append(res, fuhao10[i], fuhao10[i-1])
		} else {
			x := count / 5
			y := count % 5
			if x > 0 {
				res = append(res, fuhao5[i-1])
			}
			for j := 0; j < y; j++ {
				res = append(res, fuhao10[i])
			}
		}
	}
	return string(res)
}

// @lc code=end

/*
// @lcpr case=start
// 3749\n
// @lcpr case=end

// @lcpr case=start
// 58\n
// @lcpr case=end

// @lcpr case=start
// 1994\n
// @lcpr case=end

*/

