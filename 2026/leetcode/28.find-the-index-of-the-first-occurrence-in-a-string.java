/*
 * @lc app=leetcode.cn id=28 lang=java
 * @lcpr version=30204
 *
 * [28] 找出字符串中第一个匹配项的下标
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：直接枚举 haystack 中每个可能起点，比较长度为 needle 的子串。
// 关键点：只需要枚举到 len(haystack) - len(needle)，首次匹配立即返回下标。
// 复杂度：时间 O((n-m+1)*m)，空间 O(1) 或 O(m)，取决于切片/子串实现。
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

