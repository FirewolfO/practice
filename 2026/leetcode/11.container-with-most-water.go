/*
 * @lc app=leetcode.cn id=11 lang=golang
 * @lcpr version=30204
 *
 * [11] 盛最多水的容器
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func maxArea(height []int) int {
	left, right := 0, len(height)-1
	max := 0
	for left < right {
		max = maxVal((right-left)*minVal(height[left], height[right]), max)
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return max
}
func maxVal(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func minVal(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// @lc code=end

/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

*/

