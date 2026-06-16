/*
 * @lc app=leetcode.cn id=13 lang=golang
 * @lcpr version=30204
 *
 * [13] 罗马数字转整数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func romanToInt(s string) int {
	vv := map[string]int{
		"M":  1000,
		"CM": 900,
		"D":  500,
		"CD": 400,
		"C":  100,
		"XC": 90,
		"L":  50,
		"XL": 40,
		"X":  10,
		"IX": 9,
		"V":  5,
		"IV": 4,
		"I":  1,
	}
	ss := []rune(s)
	l := len(ss)
	res := 0
	for i := 0; i < l; i++ {
		c := ss[i]
		tmp := string(c)
		if (c == 'I' || c == 'X' || c == 'C') && i < l-1 {
			if _, ok := vv[string(ss[i:i+2])]; ok {
				tmp = string(ss[i : i+2])
				i++
			}
		}
		val := vv[tmp]
		res += val
	}
	return res
}

// @lc code=end

/*
// @lcpr case=start
// "III"\n
// @lcpr case=end

// @lcpr case=start
// "IV"\n
// @lcpr case=end

// @lcpr case=start
// "IX"\n
// @lcpr case=end

// @lcpr case=start
// "LVIII"\n
// @lcpr case=end

// @lcpr case=start
// "MCMXCIV"\n
// @lcpr case=end

*/

