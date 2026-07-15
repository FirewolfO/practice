#
# @lc app=leetcode.cn id=34 lang=python3
# @lcpr version=30204
#
# [34] 在排序数组中查找元素的第一个和最后一个位置
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1,-1]
        left = self.getLeft(nums,target)
        if left == -1:
            return [-1,-1]
        right = self.getRight(nums,target)
        return [left,right]
    def getLeft(self, nums: List[int], target: int ) -> int:
        left, right, result  = 0,len(nums)-1,-1
        while left <= right:
            mid = (left + right) // 2 
            if nums[mid] == target: 
                result = mid 
                right = mid - 1
            elif nums[mid] > target:
                right = mid - 1 
            else:
                left = mid + 1 
        return result
    def getRight(selft, nums: List[int], target: int ) -> int :
        left ,right , result = 0, len(nums)-1, -1 
        while(left <= right): 
            mid = (left + right) // 2 
            if nums[mid] == target: 
                result = mid 
                left = mid + 1 
            elif nums[mid] > target:
                right = mid -1 
            else:
                left = mid + 1 
        return result

# @lc code=end



#
# @lcpr case=start
# [5,7,7,8,8,10]\n8\n
# @lcpr case=end

# @lcpr case=start
# [5,7,7,8,8,10]\n6\n
# @lcpr case=end

# @lcpr case=start
# []\n0\n
# @lcpr case=end

#

