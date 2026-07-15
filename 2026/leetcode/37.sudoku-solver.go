/*
 * @lc app=leetcode.cn id=37 lang=golang
 * @lcpr version=30204
 *
 * [37] 解数独
 */

// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

var rows []map[byte]bool
var cols []map[byte]bool
var boxs []map[byte]bool

func solveSudoku(board [][]byte) {
	rows = make([]map[byte]bool, 9)
	cols = make([]map[byte]bool, 9)
	boxs = make([]map[byte]bool, 9)
	for i := 0; i < 9; i++ {
		rows[i] = make(map[byte]bool)
		cols[i] = make(map[byte]bool)
		boxs[i] = make(map[byte]bool)
	}
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			c := board[i][j]
			if c == '.' {
				continue
			}
			box := i/3*3 + j/3
			rows[i][c] = true
			cols[j][c] = true
			boxs[box][c] = true
		}
	}
	checkSudo(0, 0, board)
}
func checkSudo(i, j int, board [][]byte) bool {
	if i == 9 {
		return true
	}
	if j == 9 {
		return checkSudo(i+1, 0, board)
	}
	box := i/3*3 + j/3
	for num := byte('1'); num <= byte('9'); num++ {
		if board[i][j] != '.' {
			return checkSudo(i, j+1, board)
		}
		if rows[i][num] || cols[j][num] || boxs[box][num] {
			continue
		}
		board[i][j] = num
		rows[i][num] = true
		cols[j][num] = true
		boxs[box][num] = true
		if checkSudo(i, j+1, board) {
			return true
		}
		board[i][j] = '.'
		delete(rows[i], num)
		delete(cols[j], num)
		delete(boxs[box], num)
	}
	return false
}

// @lc code=end

/*
// @lcpr case=start
// [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]\n
// @lcpr case=end

*/

