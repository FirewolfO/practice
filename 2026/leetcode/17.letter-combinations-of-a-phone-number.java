/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;;

class Solution {
    Map<Character,List<Character>>  map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
       return letterCombinationsWithIndex(digits,0);
    }

    public List<String> letterCombinationsWithIndex(String digits, int index){
        if(index == digits.length()){
            return Arrays.asList("");
        }
        List<String> res = new ArrayList<>(); 
        List<Character > l = map.get(digits.charAt(index));
         List<String> xx = letterCombinationsWithIndex(digits,index+1);
        for (int i =  0 ; i < l.size(); i++){
            char c = l.get(i);
            for (int j = 0 ; j< xx.size() ;j++){
                res.add(c + xx.get(j));
            }
        }
        return res ;
    } 
}
// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

