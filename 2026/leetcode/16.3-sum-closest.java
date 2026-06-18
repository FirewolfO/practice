/*
 * @lc app=leetcode.cn id=16 lang=java
 * @lcpr version=30204
 *
 * [16] 最接近的三数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

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

