/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30204
 *
 * [22] 括号生成
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：回溯构造括号序列，记录已经使用的左括号和右括号数量。
// 关键点：左括号数量不超过 n，右括号数量不能超过左括号数量，才能保证前缀合法。
// 复杂度：时间和空间主要由答案数量决定，约为 O(C_n * n)。

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> res = new ArrayList<>();
       backtracking(res, 0, 0, n, new StringBuilder());
       return res;
    }

    void backtracking(List<String> res, int leftCount, int rightCount, int max, StringBuilder sb){
        if(sb.length() ==  2*max ){
            res.add(sb.toString());
            return;
        }
        if(leftCount < max){
            sb = sb.append("(");
            backtracking(res,leftCount+1,rightCount,max,sb);
            sb = sb.deleteCharAt(sb.length()-1);
        }
        if (leftCount > rightCount){
            sb = sb.append(")");
            backtracking(res, leftCount, rightCount+1, max, sb);
            sb = sb.deleteCharAt(sb.length()-1);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

