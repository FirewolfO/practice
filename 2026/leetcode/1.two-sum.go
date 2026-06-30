/*
 * @lc app=leetcode.cn id=1 lang=golang
 * @lcpr version=30204
 *
 * [1] 两数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：用哈希表记录已经遍历过的数字和下标，遇到当前数时直接查找 target - 当前数。
// 关键点：查找补数要发生在写入当前数之前，避免同一个元素被使用两次。
// 复杂度：时间 O(n)，空间 O(n)。
func twoSum(nums []int, target int) []int {
    
}
// @lc code=end



/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [3,3]\n6\n
// @lcpr case=end

 */

