/*
 * @lc app=leetcode.cn id=26 lang=golang
 * @lcpr version=30204
 *
 * [26] 删除有序数组中的重复项
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：数组已排序，用慢指针维护去重后数组的写入位置。
// 关键点：快指针遇到新值时写到慢指针位置，再推进慢指针。
// 复杂度：时间 O(n)，空间 O(1)。
func removeDuplicates(nums []int) int {
	count := 1
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			continue
		}
		nums[count] = nums[i]
		count++
	}
	return count
}

// @lc code=end

/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,1,1,1,2,2,3,3,4]\n
// @lcpr case=end

*/

