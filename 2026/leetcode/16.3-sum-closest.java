/*
 * @lc app=leetcode.cn id=16 lang=java
 * @lcpr version=30204
 *
 * [16] 最接近的三数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：排序后固定一个数，双指针枚举另外两个数，并记录最接近 target 的和。
// 关键点：当前和小于 target 时左指针右移，当前和大于 target 时右指针左移。
// 复杂度：时间 O(n^2)，空间 O(log n) 或 O(1)，取决于排序实现。

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1]+nums[2];
        for(int i = 0 ;i<nums.length -2 ;i++){
            int left = i + 1;
            int right = nums.length-1;
            while (left < right) {
                int sum  = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return target;
                } 
                if (Math.abs(sum -target) < Math.abs(res -target)){
                    res = sum;
                }
                if (sum > target){
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                }else{
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,2,1,-4]\n1\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n1\n
// @lcpr case=end

 */

