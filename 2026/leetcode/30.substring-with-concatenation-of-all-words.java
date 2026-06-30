/*
 * @lc app=leetcode.cn id=30 lang=java
 * @lcpr version=30204
 *
 * [30] 串联所有单词的子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：所有单词长度相同，因此按 wordLen 个偏移分组做滑动窗口。
// 关键点：窗口内按单词切片计数，遇到非法单词清空窗口，某个单词超频时从左侧收缩。
// 复杂度：时间 O(n)，空间 O(words.length)。
import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> wMap = new HashMap<>();
        for(String word : words){ 
            wMap.put(word,wMap.getOrDefault(word,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        int wordLen = words[0].length();
        for(int i = 0; i < wordLen; i++ ){
            int count = 0; 
            Map<String,Integer> sMap = new HashMap<>();
            int left = i;
            for(int right = i; right +  wordLen <= s.length(); right+=wordLen ){
                String w = s.substring(right,right+wordLen);
                if(!wMap.containsKey(w)){
                    count = 0;
                    left = right + wordLen;
                    sMap.clear();
                    continue;
                }
                                
                int sCount = sMap.getOrDefault(w, 0);
                sMap.put(w, sCount+1);
                count++;
                while (sMap.get(w) > wMap.get(w)) {
                    String leftWord = s.substring(left, left + wordLen);
                    sMap.put(leftWord, sMap.get(leftWord) - 1);
                    left += wordLen;
                    count--;
                }
                if(count == words.length){
                    res.add(left);
                    String leftWord = s.substring(left,left+wordLen);
                    sMap.put(leftWord,sMap.get(leftWord)-1);
                    left += wordLen;
                    count--;
                }
            }
           
        }
        return res ;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "barfoothefoobarman"\n["foo","bar"]\n
// @lcpr case=end

// @lcpr case=start
// "wordgoodgoodgoodbestword"\n["word","good","best","word"]\n
// @lcpr case=end

// @lcpr case=start
// "barfoofoobarthefoobarman"\n["bar","foo","the"]\n
// @lcpr case=end

 */

