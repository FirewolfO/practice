/*
 * @lc app=leetcode.cn id=13 lang=java
 * @lcpr version=30204
 *
 * [13] 罗马数字转整数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：从左到右扫描罗马数字，优先识别 IV、IX、XL、XC、CD、CM 这类双字符组合。
// 关键点：当当前位置可能构成减法组合时先查两个字符，命中后跳过下一位。
// 复杂度：时间 O(n)，空间 O(1)。

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> vv = new HashMap<>();
        vv.put("M", 1000);
		 vv.put("CM", 900);
		 vv.put("D", 500);
		 vv.put("CD",400);
		 vv.put("C", 100);
		 vv.put("XC",90);
		 vv.put("L", 50);
		 vv.put("XL",40);
	     vv.put("X", 10);
		 vv.put("IX", 9);
		 vv.put("V",5);
		 vv.put("IV", 4);
		 vv.put("I", 1);
         int res = 0;
         for(int i =0 ;i < s.length(); i++){
            char c = s.charAt(i);
            String tmp = s.substring(i, i+1);
            if ((c == 'C' || c== 'X' || c == 'I' ) && i < s.length()-1){
                String x = s.substring(i,i+2);
                if (vv.containsKey(x)){
                    tmp = x;
                    i++;
                }
            }
            res += vv.get(tmp);
         }
         return res ;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "III"\n
// @lcpr case=end

// @lcpr case=start
// "IV"\n
// @lcpr case=end

// @lcpr case=start
// "IX"\n
// @lcpr case=end

// @lcpr case=start
// "LVIII"\n
// @lcpr case=end

// @lcpr case=start
// "MCMXCIV"\n
// @lcpr case=end

 */

