#
# @lc app=leetcode.cn id=37 lang=python3
# @lcpr version=30204
#
# [37] 解数独
#


# @lcpr-template-start

# @lcpr-template-end
# @lc code=start
class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.rows = [set() for _ in range(9)]
        self.cols = [set() for _ in range(9)]
        self.boxs = [set() for _ in range(9)]
        for i in range(9):
            for j in range(9):
                c = board[i][j]
                if board[i][j] == '.':
                    continue
                self.rows[i].add(c)
                self.cols[j].add(c)
                self.boxs[i//3*3+j//3].add(c)
        self.check(0,0,board)

    def check(self, i: int, j: int,  board: List[List[str]]) -> bool:
        if i == 9: 
            return True
        if j == 9:
            return self.check(i+1,0,board)
        if board[i][j] != '.':
            return self.check(i,j+1,board)
        box = i // 3 * 3 + j //3 
        for num in '123456789':
            if num in self.rows[i] or num in self.cols[j] or num in self.boxs[box]:
                continue
            board[i][j] = num
            self.rows[i].add(num)
            self.cols[j].add(num)
            self.boxs[box].add(num)
            if self.check(i,j+1,board):
                return True
            board[i][j] = '.'
            self.rows[i].remove(num)
            self.cols[j].remove(num)
            self.boxs[box].remove(num)
        return False
# @lc code=end



#
# @lcpr case=start
# [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
# @lcpr case=end

#

