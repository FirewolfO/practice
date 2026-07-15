/*
 * @lc app=leetcode.cn id=36 lang=java
 * @lcpr version=30204
 *
 * [36] 有效的数独
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.*;;
class Solution {
    public boolean isValidSudoku(char[][] board) { 
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> boxs = new ArrayList<>();
        for(int i = 0; i < 9;i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxs.add(new HashSet<>());
        }
        for(int i = 0;i<9; i++){
            for( int j = 0 ;j < 9;j++){
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int box = i / 3  * 3 + j/3;
                if(rows.get(i).contains(c) || cols.get(j).contains(c) || boxs.get(box).contains(c)){
                    return false;
                }
                rows.get(i).add(c);
                cols.get(j).add(c);
                boxs.get(box).add(c);
            }
        }
        return true ;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

// @lcpr case=start
// [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

 */

