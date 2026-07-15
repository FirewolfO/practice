#
# @lc app=leetcode.cn id=36 lang=python3
# @lcpr version=30204
#
# [36] 有效的数独
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        cols,rows,boxs = [],[],[]
        for i in range(9):
            cols = [set() for _ in range(9)]
            rows = [set() for _ in range(9)]
            boxs = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                c = board[i][j]
                if c == '.':
                    continue
                box = i // 3 * 3 + j // 3
                if c in rows[i] or c in cols[j]or  c in  boxs[box]:
                    return False
                rows[i].add(c)
                cols[j].add(c)
                boxs[box].add(c)
        return True
# @lc code=end



#
# @lcpr case=start
# [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
# @lcpr case=end

# @lcpr case=start
# [["8","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
# @lcpr case=end

#

