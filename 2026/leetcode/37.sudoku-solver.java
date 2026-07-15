/*
 * @lc app=leetcode.cn id=37 lang=java
 * @lcpr version=30204
 *
 * [37] 解数独
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.*;

class Solution {
    Map<Integer,Set<Character>> cols = new HashMap<>();
    Map<Integer,Set<Character>> rows = new HashMap<>();
    Map<Integer,Set<Character>> boxs = new HashMap<>(); 
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            cols.put(i, new HashSet<>());
            rows.put(i, new HashSet<>());
            boxs.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.'){
                    continue;
                }
                rows.get(i).add(c);
                cols.get(j).add(c);
                boxs.get(i / 3 * 3 + j / 3).add(c);
            }
        }
        checkSudo(0, 0, board);
    }
    boolean checkSudo(int i, int j, char[][] board){
        if(i == 9){
            return true;
        }
        if(j == 9){
            return checkSudo(i+1, 0, board);
        }
        if(board[i][j] != '.'){
            return checkSudo(i,j+1,board);
        }
        int box = i / 3 * 3 + j / 3; 
        for(char num = '1'; num <= '9' ;num++){
           if(rows.get(i).contains(num) 
                || cols.get(j).contains(num)
                || boxs.get(box).contains(num)){
                    continue;
            }
            board[i][j] = num;
            rows.get(i).add(num);
            cols.get(j).add(num);
            boxs.get(box).add(num);
            if(checkSudo(i, j+ 1, board)){
                return true;
            }
            // 回溯
            board[i][j] = '.';
            rows.get(i).remove(num);
            cols.get(j).remove(num);
            boxs.get(box).remove(num);
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

 */

