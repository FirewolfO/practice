#
# @lc app=leetcode.cn id=29 lang=python3
# @lcpr version=30204
#
# [29] 两数相除
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
# 核心思路：把除数不断倍增，找到不超过被除数的最大倍数后递归/迭代扣减。
# 关键点：统一用正负号处理结果方向，并对 32 位整数溢出边界做截断。
# 复杂度：时间 O(log|dividend|)，空间 O(log|dividend|) 或 O(1)，取决于实现是否递归。
import math
class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        flag = 1 
        if (dividend > 0 and divisor < 0 ) or  (dividend < 0 and divisor > 0 ):
            flag = -1
        dividendL,divisorL = abs(dividend), abs(divisor)
        divisorO = divisorL
        tmp = 1
        while dividendL >= divisorL + divisorL: 
            divisorL <<= 1 
            tmp <<= 1
        res = 0
        while dividendL >= divisorO: 
            if dividendL >= divisorL: 
                res += tmp 
                dividendL -= divisorL
            tmp >>= 1
            divisorL >>= 1
        maxInt32 = 2**31 -1 
        if flag == 1 and res > maxInt32:
            return maxInt32
        return res * flag
        
# @lc code=end



#
# @lcpr case=start
# 10\n3\n
# @lcpr case=end

# @lcpr case=start
# 7\n-3\n
# @lcpr case=end

#

