/*
 * @lc app=leetcode.cn id=8 lang=java
 * @lcpr version=30204
 *
 * [8] 字符串转换整数 (atoi)
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：依次跳过前导空格、读取符号、累积连续数字。
// 关键点：累积过程中及时按 32 位整数上下界截断，遇到非数字立即停止。
// 复杂度：时间 O(n)，空间 O(1)。
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while (i<s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if(i == s.length()){
            return 0;
        }
        int flag = 1;
        char c = s.charAt(i);
        if (c == '+' || c == '-'){
            i++;
            if(c == '-'){
                flag = -1;
            }
        }
        long res = 0;
        while (i<s.length()) {
            char x = s.charAt(i);
            if(x > '9' || x < '0'){
               break;
            }
            res = res * 10 + (x-'0');
            if(flag == 1 && res > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(flag == -1 && res > Integer.MAX_VALUE + (long)1 ){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(res * flag);
    }
}
// @lc code=end



/*
// @lcpr case=start
// "42"\n
// @lcpr case=end

// @lcpr case=start
// " -042"\n
// @lcpr case=end

// @lcpr case=start
// "1337c0d3"\n
// @lcpr case=end

// @lcpr case=start
// "0-1"\n
// @lcpr case=end

// @lcpr case=start
// "words and 987"\n
// @lcpr case=end

 */

