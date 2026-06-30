/*
 * @lc app=leetcode.cn id=27 lang=golang
 * @lcpr version=30204
 *
 * [27] 移除元素
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：用写指针覆盖保留下来的元素，把不等于 val 的值依次放到数组前部。
// 关键点：题目只关心返回长度以内的内容，后半段遗留值无需处理。
// 复杂度：时间 O(n)，空间 O(1)。
func removeElement(nums []int, val int) int {
	count := 0
	for i := 0; i < len(nums); i++ {
		if nums[i] != val {
			nums[count] = nums[i]
			count++
		}
	}
	return count
}

// @lc code=end

/*
// @lcpr case=start
// [3,2,2,3]\n3\n
// @lcpr case=end

// @lcpr case=start
// [0,1,2,2,3,0,4,2]\n2\n
// @lcpr case=end

*/

