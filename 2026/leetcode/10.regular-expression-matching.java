/*
 * @lc app=leetcode.cn id=10 lang=java
 * @lcpr version=30204
 *
 * [10] 正则表达式匹配
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 *  p[j] 不是* 
 *      dp[i][j] = dp[i-1][j-1] && s[i-1] == p[j-1]
 *  为 * 
 *    匹配0次
 *      dp[i][j] = dp[i][j-1] 
 *    匹配1次
 *      dp[i][j] = dp[i-1][j-2] && s[i-1] = p[j-1]  
 *    匹配2次
 *      dp[i][j] = dp[i-2][j-2] && s[i-1] = p[j-1] &&  s[i-2】 = p[j-1]
 *    匹配3次
 *    dp[i][j-2] || dp[i-1][j]
 *    
 * 
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1;
        int n = p.length() + 1;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] dp = new boolean[m][n];
        dp[0][0]= true;
        for(int j = 2; j < n ;j+=2){
            dp[0][j] = dp[0][j-2] && pp[j-1] == '*';
        }
        for (int i = 1 ;i < m; i++){
            for (int j = 1 ; j < n; j++){
                if(pp[j-1] == '*'){
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] && (ss[i-1] == pp[j-2] || pp[j-2] == '.');
                }else {
                    dp[i][j] =  dp[i-1][j-1] && (ss[i-1] == pp[j-1] || pp[j-1] == '.');
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end



/*
// @lcpr case=start
// "aa"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "aa"\n"a*"\n
// @lcpr case=end

// @lcpr case=start
// "ab"\n".*"\n
// @lcpr case=end

 */

