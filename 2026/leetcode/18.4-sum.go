import "sort"

/*
 * @lc app=leetcode.cn id=18 lang=golang
 * @lcpr version=30204
 *
 * [18] 四数之和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	res := make([][]int, 0)
	tt := int64(target)
	for i := 0; i < len(nums)-3; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		for j := i + 1; j < len(nums)-2; j++ {
			if j > i+1 && nums[j] == nums[j-1] {
				continue
			}
			left, right := j+1, len(nums)-1
			for left < right {
				sum := int64(nums[i]) + int64(nums[j]) + int64(nums[left]) + int64(nums[right])
				if sum == tt {
					res = append(res, []int{nums[i], nums[j], nums[left], nums[right]})
					for left < right && nums[left] == nums[left+1] {
						left++
					}
					for left < right && nums[right] == nums[right-1] {
						right--
					}
					left++
					right--
				} else if sum > tt {
					right--
				} else {
					left++
				}
			}
		}
	}
	return res
}

// @lc code=end

/*
// @lcpr case=start
// [1,0,-1,0,-2,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [2,2,2,2,2]\n8\n
// @lcpr case=end

*/

