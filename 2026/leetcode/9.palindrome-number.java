/*
 * @lc app=leetcode.cn id=9 lang=java
 * @lcpr version=30204
 *
 * [9] 回文数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0)){
            return false;
        }
        int  y = 0 ;
        while (x > y) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return x == y || x == y/10;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 121\n
// @lcpr case=end

// @lcpr case=start
// -121\n
// @lcpr case=end

// @lcpr case=start
// 10\n
// @lcpr case=end

 */

