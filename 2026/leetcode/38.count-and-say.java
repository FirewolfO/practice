/*
 * @lc app=leetcode.cn id=38 lang=java
 * @lcpr version=30204
 *
 * [38] 外观数列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String s = countAndSay(n-1);
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char c = s.charAt(0);
        int len = s.length();
        int i = 1;
        for (;i < len;i++ ) { 
            if(s.charAt(i) == c){
                count++;
            }else{
                sb.append(count).append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        sb = sb.append(count).append(c);
        return sb.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// 4\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

