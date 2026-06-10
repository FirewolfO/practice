/*
 * @lc app=leetcode.cn id=4 lang=java
 * @lcpr version=30204
 *
 * [4] 寻找两个正序数组的中位数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int left = 0;
        int right = m;
        int mid1 = 0;
        int mid2 = 0;
        while( left <= right){
            int i = (left + right) /2 ;
            int j = (m+n+1)/2 - i;
            int lm = Integer.MIN_VALUE;
            int rm = Integer.MAX_VALUE;
            int ln = Integer.MIN_VALUE;
            int rn = Integer.MAX_VALUE;   
            if (i > 0){
                lm = nums1[i-1];
            } 
            if (i<m){
                rm = nums1[i];
            }   
            if (j > 0){
                ln = nums2[j-1];
            } 
            if (j<n){
                rn = nums2[j];
            }
            if (lm <= rn){
                mid1 = max(lm,ln);
                mid2 = min(rm,rn);
                left = i + 1;
            }else{
                right = i - 1;
            }
        }
        if ((m+n) % 2 == 0){
            return (double)(mid1+mid2) / 2.0;
        }
        return mid1 * 1.0;
    }
    int max(int a, int b ) {
        if (a > b){
            return a;
        }
        return b;
    }
    int min(int a, int b) {
        if (a < b){
            return a;
        }
        return b;
    }
}


// @lc code=end



/*
// @lcpr case=start
// [1,3]\n[2]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n[3,4]\n
// @lcpr case=end

 */

