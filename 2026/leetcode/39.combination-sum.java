/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30204
 *
 * [39] 组合总和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    void find (int[] candidates, int start,int target, List<Integer> item,  List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(item));
        }
        for (int i = start; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            item.add(candidates[i]);
            find(candidates, i, target - candidates[i], item, res);
            item.remove(item.size()-1);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

