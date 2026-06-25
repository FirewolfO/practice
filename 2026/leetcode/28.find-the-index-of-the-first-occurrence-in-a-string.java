/*
 * @lc app=leetcode.cn id=28 lang=java
 * @lcpr version=30204
 *
 * [28] 找出字符串中第一个匹配项的下标
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int l = needle.length();
        for(int i = 0; i <= haystack.length() -l ;i++){
            String sub = haystack.substring(i,i+l);
            if(sub.equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "sadbutsad"\n"sad"\n
// @lcpr case=end

// @lcpr case=start
// "leetcode"\n"leeto"\n
// @lcpr case=end

 */

