#
# @lc app=leetcode.cn id=30 lang=python3
# @lcpr version=30204
#
# [30] 串联所有单词的子串
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        res = []
        wordLen = len(words[0])
        wMap = {}
        for word in words:
            wMap[word] = wMap.get(word,0)+1
        for i in range(wordLen): 
            left = i
            right = i
            window = {}
            count = 0
            while right + wordLen <= len(s):
                word = s[right:right+wordLen]
                if word not in wMap:
                    count = 0
                    window = {}
                    left = right+wordLen
                    right += wordLen
                    continue
                count += 1
                window[word] = window.get(word, 0) + 1
                while window[word] > wMap[word]: 
                    leftWord = s[left:left+wordLen]
                    window[leftWord] = window[leftWord]-1
                    count -= 1
                    left = left + wordLen
                if count == len(words):
                    res.append(left)
                    leftWord = s[left:left+wordLen]
                    window[leftWord] = window[leftWord]-1
                    count -= 1
                    left = left + wordLen
                right+=wordLen
        return res 
        
# @lc code=end



#
# @lcpr case=start
# "barfoothefoobarman"\n["foo","bar"]\n
# @lcpr case=end

# @lcpr case=start
# "wordgoodgoodgoodbestword"\n["word","good","best","word"]\n
# @lcpr case=end

# @lcpr case=start
# "barfoofoobarthefoobarman"\n["bar","foo","the"]\n
# @lcpr case=end

#

