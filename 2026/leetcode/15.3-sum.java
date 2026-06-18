/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30204
 *
 * [15] 三数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                     List<Integer> iterm = new ArrayList<>();
                    iterm.add(nums[i]);
                    iterm.add(nums[left]);
                    iterm.add(nums[right]);
                    res.add(iterm); 
                    while (left < right && nums[left] == nums[left+1])  {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1])  {
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else{
                    left++;
                }
            }
      
        }
       return res ;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,0,1,2,-1,-4]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n
// @lcpr case=end

 */

