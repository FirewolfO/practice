from typing import List


class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Modify nums in-place to the next lexicographically larger permutation.
        If no larger permutation exists, reverse the whole array to the minimum one.
        """
        n = len(nums)
        if n < 2:
            return

        # Find the first position from the right that can be increased.
        # The suffix after pivot is non-increasing, so it is already maximal.
        pivot = n - 2
        while pivot >= 0 and nums[pivot] >= nums[pivot + 1]:
            pivot -= 1

        if pivot >= 0:
            # From the right, find the smallest increase for nums[pivot].
            successor = n - 1
            while nums[successor] <= nums[pivot]:
                successor -= 1
            nums[pivot], nums[successor] = nums[successor], nums[pivot]

        # Reverse the suffix to make it as small as possible for the new prefix.
        left, right = pivot + 1, n - 1
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
