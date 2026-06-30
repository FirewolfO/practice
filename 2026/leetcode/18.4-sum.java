/*
 * @lc app=leetcode.cn id=18 lang=java
 * @lcpr version=30204
 *
 * [18] 四数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：排序后固定前两个数，在剩余区间用双指针寻找满足 target 的后两个数。
// 关键点：多层枚举都要跳过重复值，并用更宽的整数类型避免四数相加溢出。
// 复杂度：时间 O(n^3)，空间 O(log n) 或 O(1)，取决于排序实现。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>  res = new ArrayList<>();
        for(int i = 0; i< nums.length - 3 ;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j< nums.length-2;j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                } 
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }else if (sum > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,0,-1,0,-2,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [2,2,2,2,2]\n8\n
// @lcpr case=end

 */

