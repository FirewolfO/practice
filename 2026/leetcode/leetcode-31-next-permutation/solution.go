// nextPermutation modifies nums in-place to the next lexicographically larger
// permutation. If nums is already the largest permutation, it becomes the
// smallest permutation by reversing the whole array.
func nextPermutation(nums []int) {
	n := len(nums)
	if n < 2 {
		return
	}

	// Scan from right to left and find the first position that can be increased.
	// Everything after pivot is non-increasing, so that suffix is already maximal.
	pivot := n - 2
	for pivot >= 0 && nums[pivot] >= nums[pivot+1] {
		pivot--
	}

	if pivot >= 0 {
		// In the non-increasing suffix, the first value from the right that is
		// larger than nums[pivot] is the smallest possible increase.
		successor := n - 1
		for nums[successor] <= nums[pivot] {
			successor--
		}
		nums[pivot], nums[successor] = nums[successor], nums[pivot]
	}

	// Make the suffix as small as possible. If there is no pivot, this reverses
	// the whole array into ascending order.
	reverse(nums, pivot+1, n-1)
}

func reverse(nums []int, left int, right int) {
	for left < right {
		nums[left], nums[right] = nums[right], nums[left]
		left++
		right--
	}
}
