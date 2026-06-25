#
# @lc app=leetcode.cn id=28 lang=python3
# @lcpr version=30204
#
# [28] 找出字符串中第一个匹配项的下标
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        l = len(needle)
        i = 0 
        while i <= len(haystack)-l: 
            subStr = haystack[i:i+l]
            if subStr == needle: 
                return i  
            i+=1 
        return -1
# @lc code=end



#
# @lcpr case=start
# "sadbutsad"\n"sad"\n
# @lcpr case=end

# @lcpr case=start
# "leetcode"\n"leeto"\n
# @lcpr case=end

#

