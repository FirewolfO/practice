/*
 * @lc app=leetcode.cn id=6 lang=golang
 * @lcpr version=30204
 *
 * [6] Z 字形变换
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func convert(s string, numRows int) string {
	if numRows == 1 || len(s) <= numRows {
		return s
	}
	l := len(s)
	arry := make([][]rune, numRows)
	for i := 0; i < numRows; i++ {
		arry[i] = make([]rune, l)
	}
	ss := []rune(s)
	j := 0
	x := 0
	for x < l {
		for i := 0; i < numRows && x < l; i++ {
			arry[i][j] = ss[x]
			x++
		}
		j++
		for i := numRows - 2; i > 0 && x < l; i-- {
			arry[i][j] = ss[x]
			j++
			x++
		}
	}
	res := make([]rune, 0)
	for i := 0; i < numRows; i++ {
		for j := 0; j < l; j++ {
			if arry[i][j] == 0 {
				continue
			}
			res = append(res, arry[i][j])
		}
	}
	return string(res)
}

// @lc code=end

/*
// @lcpr case=start
// "PAYPALISHIRING"\n3\n
// @lcpr case=end

// @lcpr case=start
// "PAYPALISHIRING"\n4\n
// @lcpr case=end

// @lcpr case=start
// "A"\n1\n
// @lcpr case=end

*/

