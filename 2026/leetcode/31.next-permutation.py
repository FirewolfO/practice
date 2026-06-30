#
# @lc app=leetcode.cn id=31 lang=python3
# @lcpr version=30204
#
# [31] 下一个排列
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        left = -1 
        for i in range(len(nums)-1,0,-1):
            if nums[i] > nums[i-1]:
                left = i-1
                break
        if left != -1:
            right = len(nums)-1
            while right > left:
                if nums[right] > nums[left]:
                    tmp = nums[right]
                    nums[right] = nums[left]
                    nums[left] = tmp
                    break
                right -= 1
        start, end = left + 1, len(nums)-1
        while start < end :
            tmp = nums[start]
            nums[start] = nums[end]
            nums[end] = tmp
            start += 1 
            end -= 1
        
# @lc code=end



#
# @lcpr case=start
# [1,2,3]\n
# @lcpr case=end

# @lcpr case=start
# [3,2,1]\n
# @lcpr case=end

# @lcpr case=start
# [1,1,5]\n
# @lcpr case=end

#

