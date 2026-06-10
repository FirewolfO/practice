/*
 * @lc app=leetcode.cn id=5 lang=java
 * @lcpr version=30204
 *
 * [5] 最长回文子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 0){
            return "";
        }
        char[] ss = s.toCharArray();
        int maxLen = 0;
        int start = 0;
        for(int i=0; i<ss.length;i++){ 
            int l1 = getLongs1t(ss, i, i);
            int l2 = getLongs1t(ss, i, i+1);

            int m = Math.max(l1,l2);
            if (m > maxLen){
                start = i - (m-1)/2;
                maxLen = m;
            }
        } 
        return s.substring(start,start+maxLen);
    }
    int getLongs1t(char[] ss, int left, int right){
        while (left >= 0 && right < ss.length && ss[left] == ss[right]) {
            left--;
            right++;
        }
        return right - left - 1 ;
    } 
}
// @lc code=end



/*
// @lcpr case=start
// "babad"\n
// @lcpr case=end

// @lcpr case=start
// "cbbd"\n
// @lcpr case=end

 */

