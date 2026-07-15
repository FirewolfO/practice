import "sort"

/*
 * @lc app=leetcode.cn id=39 lang=golang
 * @lcpr version=30204
 *
 * [39] 组合总和
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
func combinationSum(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	res := make([][]int, 0)
	dfs(candidates, 0, target, make([]int, 0), &res)
	return res
}
func dfs(candidates []int, start, target int, item []int, res *[][]int) {
	if target == 0 {
		x := append([]int(nil), item...)
		*res = append(*res, x)
		return
	}
	for i := start; i < len(candidates); i++ {
		if candidates[i] > target {
			break
		}
		item = append(item, candidates[i])
		dfs(candidates, i, target-candidates[i], item, res)
		item = item[0 : len(item)-1]
	}
}

// @lc code=end

/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

*/

