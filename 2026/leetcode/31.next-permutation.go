/*
 * @lc app=leetcode.cn id=31 lang=golang
 * @lcpr version=30204
 *
 * [31] 下一个排列
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func nextPermutation(nums []int) {
	left := -1
	for i := len(nums) - 1; i > 0; i-- {
		if nums[i] > nums[i-1] {
			left = i - 1
			break
		}
	}
	if left != -1 {
		for i := len(nums) - 1; i > left; i-- {
			if nums[i] > nums[left] {
				nums[i], nums[left] = nums[left], nums[i]
				break
			}
		}
	}
	start, end := left+1, len(nums)-1
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}

// @lc code=end

/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,5]\n
// @lcpr case=end

*/

