/*
 * @lc app=leetcode.cn id=20 lang=java
 * @lcpr version=30204
 *
 * [20] 有效的括号
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：用栈保存尚未匹配的左括号，遇到右括号时检查栈顶是否对应。
// 关键点：右括号到来时栈为空或类型不匹配都立即返回 false，最后栈必须为空。
// 复杂度：时间 O(n)，空间 O(n)。

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()){
                    return false;
                }
                char x = stack.pop();
                char v = map.get(c);
                if(v != x){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "()"\n
// @lcpr case=end

// @lcpr case=start
// "()[]{}"\n
// @lcpr case=end

// @lcpr case=start
// "(]"\n
// @lcpr case=end

// @lcpr case=start
// "([])"\n
// @lcpr case=end

// @lcpr case=start
// "([)]"\n
// @lcpr case=end

 */

