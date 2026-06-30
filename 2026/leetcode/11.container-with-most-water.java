/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30204
 *
 * [11] 盛最多水的容器
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：双指针从两端向中间收缩，每次用较短边决定当前容量。
// 关键点：移动较短的那一侧才可能得到更高的边界，从而产生更大的面积。
// 复杂度：时间 O(n)，空间 O(1)。
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1 ;
        int max = 0;
        while(left < right){
            int tmp = (right-left) * Math.min(height[left], height[right]);
            max = Math.max(max,tmp);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

 */

