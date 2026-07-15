#
# @lc app=leetcode.cn id=38 lang=python3
# @lcpr version=30204
#
# [38] 外观数列
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        s = self.countAndSay(n-1)
        c = s[0]
        count = 1 
        res = ""
        for i in range (1, len(s)):
            if s[i] == c:
                count+=1
            else:
                res = res + str(count) + c
                count = 1 
                c  = s[i]
        res = res + str(count) + c
        return res 
        
# @lc code=end



#
# @lcpr case=start
# 4\n
# @lcpr case=end

# @lcpr case=start
# 1\n
# @lcpr case=end

#

