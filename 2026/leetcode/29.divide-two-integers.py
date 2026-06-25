#
# @lc app=leetcode.cn id=29 lang=python3
# @lcpr version=30204
#
# [29] 两数相除
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
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

