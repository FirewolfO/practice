/*
 * @lc app=leetcode.cn id=14 lang=java
 * @lcpr version=30204
 *
 * [14] 最长公共前缀
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：以第一个字符串为基准，逐列比较所有字符串的同一位置字符。
// 关键点：任一字符串结束或字符不相等时，当前位置之前就是最长公共前缀。
// 复杂度：时间 O(S)，空间 O(1)，S 为参与比较的字符总数。
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i =0;
        for (;i < strs[0].length();i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){ 
                    return strs[0].substring(0,i);
                }
            } 
        }
        return strs[0].substring(0,i);
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["flower","flow","flight"]\n
// @lcpr case=end

// @lcpr case=start
// ["dog","racecar","car"]\n
// @lcpr case=end

 */

