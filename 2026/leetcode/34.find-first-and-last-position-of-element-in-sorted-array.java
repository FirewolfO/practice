/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=30204
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0){
            return new int[]{-1,-1};
        }
        int left = findLeft(nums, target);
        if(left == -1){
            return new int[]{-1,-1}; 
        }
        int right = findRight(nums,target);
        return new int[]{left,right};
    }
    int findLeft(int[] nums , int target){
        int left = 0;
        int right = nums.length-1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) /2 ;
            if(nums[mid] < target){
                left = mid+1;
            }else if (nums[mid]==target){
                result = mid;
                right = mid -1;
            }else{
                right = mid -1 ;
            }
        }
        return result;
    }
    int findRight(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] < target){
                left = mid + 1 ;
            }else if(nums[mid] == target){
                result = mid ;
                left = mid + 1 ;
            }else{
                right = mid - 1 ;
            }
        } 
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

