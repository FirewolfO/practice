#
# @lc app=leetcode.cn id=32 lang=python3
# @lcpr version=30204
#
# [32] 最长有效括号
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
# # 方法一、 栈
# class Solution:
#     def longestValidParentheses(self, s: str) -> int:
#         if len(s) < 2:
#             return 0
#         max = 0 
#         stack = [-1]
#         for idx, c in enumerate(s):
#             if c == '(':
#                 stack.append(idx)
#             else: 
#                 stack = stack[:len(stack)-1]
#                 if len(stack) == 0:
#                     stack.append(idx)
#                 else:
#                     l = idx - stack[len(stack)-1]
#                     if l > max:
#                         max = l 
#         return max    

# 方法二
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if len(s) < 2:
            return 0
        max = 0 
        dp = [0] * len(s)
        for i in range(1, len(s)):
            if s[i] == '(':
                continue
            if s[i-1] == '(':
                dp[i] = 2 
                if i >= 2:
                     dp[i] += dp[i-2] 
            else:
                if i - dp[i-1]-1 >=0 and s[i - dp[i-1]-1] == '(':
                    dp[i] = dp[i-1]+2
                    if i - dp[i-1]-2 >=0:
                        dp[i] += dp[i - dp[i-1]-2]
            if dp[i] > max:
                max = dp[i]
        return max            
        
# @lc code=end



#
# @lcpr case=start
# "(()"\n
# @lcpr case=end

# @lcpr case=start
# ")()())"\n
# @lcpr case=end

# @lcpr case=start
# ""\n
# @lcpr case=end

#

