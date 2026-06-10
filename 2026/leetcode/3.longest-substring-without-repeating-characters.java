/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character,Boolean> m = new HashMap<>();
        while (right < s.length()) {
            while (left < right && m.containsKey(s.charAt(right))) {
                m.remove(s.charAt(left));
                left++;
            }
            m.put(s.charAt(right), true);
            if(right - left + 1  > maxLen){
                maxLen = right - left + 1;
            }
            right++;
        }
        return maxLen;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

