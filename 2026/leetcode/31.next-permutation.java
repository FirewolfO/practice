/*
 * @lc app=leetcode.cn id=31 lang=java
 * @lcpr version=30204
 *
 * [31] 下一个排列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int left = -1;
        int right = -1;
        for(int i = nums.length - 1 ;i > 0;i--){
            if(nums[i] > nums[i-1]){
                left = i-1;
                right = i;
                break;
            }
        }
        if(left != -1){
            for (int i = nums.length-1; i > left;i--){
                if (nums[i] > nums[left]){
                    int tmp = nums[i];
                    nums[i] = nums[left];
                    nums[left] = tmp;
                    break;
                }
            }
        }
        int start = left + 1;
        right = nums.length-1;
        while (start < right) {
            int tmp = nums[start];
            nums[start] = nums[right];
            nums[right] = tmp;
            start++;
            right--;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [3,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,5]\n
// @lcpr case=end

 */

