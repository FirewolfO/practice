import "math"

/*
 * @lc app=leetcode.cn id=4 lang=golang
 * @lcpr version=30204
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) > len(nums2) {
		return findMedianSortedArrays(nums2, nums1)
	}
	m, n := len(nums1), len(nums2)
	left, right := 0, m
	mid1, mid2 := 0, 0
	for left <= right {
		i := (left + right) / 2
		j := (m+n+1)/2 - i
		lm, ln, rm, rn := math.MinInt, math.MinInt, math.MaxInt, math.MaxInt
		if i > 0 {
			lm = nums1[i-1]
		}
		if i < m {
			rm = nums1[i]
		}
		if j > 0 {
			ln = nums2[j-1]
		}
		if j < n {
			rn = nums2[j]
		}
		if lm <= rn {
			mid1 = max(lm, ln)
			mid2 = min(rm, rn)
			left = i + 1
		} else {
			right = i - 1
		}
	}
	if (m+n)%2 == 0 {
		return float64(mid1+mid2) / 2.0
	}
	return float64(mid1)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

// @lc code=end

/*
// @lcpr case=start
// [1,3]\n[2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n[3,4]\n
// @lcpr case=end

*/

