/*
 * @lc app=leetcode.cn id=34 lang=golang
 * @lcpr version=30204
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func searchRange(nums []int, target int) []int {
	if len(nums) == 0 {
		return []int{-1, -1}
	}
	left := findLeft(nums, target)
	if left == -1 {
		return []int{-1, -1}
	}
	return []int{left, findRight(nums, target)}
}
func findLeft(nums []int, target int) int {
	left, right, result := 0, len(nums)-1, -1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			result = mid
			right = mid - 1
		}
	}
	return result
}
func findRight(nums []int, target int) int {
	left, right, result := 0, len(nums)-1, -1
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			result = mid
			left = mid + 1
		}
	}
	return result
}

// @lc code=end

/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

*/

