/*
 * @lc app=leetcode.cn id=32 lang=java
 * @lcpr version=30204
 *
 * [32] 最长有效括号
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start 
// 方法一： 栈
// import java.util.Stack;
// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack<Integer>  stack = new Stack<Integer>();
//         int maxLen = 0;
//         stack.push(-1); 
//         for(int i = 0; i<s.length();i++){
//             if(s.charAt(i) == '('){ 
//                 stack.push(i); 
//             }else{
//                 stack.pop();
//                 if(stack.isEmpty()){
//                     stack.push(i);
//                 }else{
//                     maxLen = Math.max(maxLen, i - stack.peek());
//                 }
//             }
//         }
//         return maxLen;
//     }
// }

// 方法二、动态规划
class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2){
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++){ 
            if(s.charAt(i) == '('){
                dp[i] = 0;
                continue;
            }
           
            if(s.charAt(i-1) == '('){
                dp[i] = (i>1?dp[i-2]:0) + 2;
            }else{
                if( i- dp[i-1]-1 >= 0 && s.charAt(i- dp[i-1]-1) == '('){
                    dp[i] = dp[i-1] + 2;
                    if(i - dp[i-1] -2 >= 0){
                        dp[i] += dp[i - dp[i-1] -2];
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "(()"\n
// @lcpr case=end

// @lcpr case=start
// ")()())"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

 */

