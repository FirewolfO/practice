/*
 * @lc app=leetcode.cn id=29 lang=java
 * @lcpr version=30204
 *
 * [29] 两数相除
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：把除数不断倍增，找到不超过被除数的最大倍数后递归/迭代扣减。
// 关键点：统一用正负号处理结果方向，并对 32 位整数溢出边界做截断。
// 复杂度：时间 O(log|dividend|)，空间 O(log|dividend|) 或 O(1)，取决于实现是否递归。
class Solution {
    public int divide(int dividend, int divisor) {
        int  flag = 1;

        if(dividend >0 && divisor < 0 || dividend <0 && divisor > 0){
            flag = -1;
        }
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);
        long divisorA = divisorL;
        long res = 0;
        long tmp = 1;
        while (dividendL >= divisorL + divisorL) {
            divisorL <<= 1;
            tmp <<= 1;
        }
        while(dividendL >= divisorA){ 
            if(dividendL >= divisorL){
                dividendL -= divisorL;
                res += tmp;
            }
            divisorL  >>= 1 ;
            tmp >>= 1;
        }
        if(res > Integer.MAX_VALUE && flag == 1){
            return Integer.MAX_VALUE;   
        }
        return (int)res * flag;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 10\n3\n
// @lcpr case=end

// @lcpr case=start
// 7\n-3\n
// @lcpr case=end

 */

