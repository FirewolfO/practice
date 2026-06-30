/*
 * @lc app=leetcode.cn id=5 lang=java
 * @lcpr version=30204
 *
 * [5] 最长回文子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：枚举每个字符作为回文中心，分别向两侧扩展奇数和偶数长度回文。
// 关键点：扩展结束后返回真实边界，并用最长边界截取答案。
// 复杂度：时间 O(n^2)，空间 O(n) 或 O(1)，取决于语言中的字符串切片/字符数组。
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

