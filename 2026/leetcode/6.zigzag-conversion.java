/*
 * @lc app=leetcode.cn id=6 lang=java
 * @lcpr version=30204
 *
 * [6] Z 字形变换
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 核心思路：按 Z 字形书写顺序把字符放入各行/矩阵，再按行读取结果。
// 关键点：numRows 为 1 或字符串长度不超过行数时无需转换，直接返回原串。
// 复杂度：时间 O(n)，空间 O(n)。
class Solution {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows == 1){
            return s; 
        }
        int len = s.length(); 
        char[][] arry = new char[numRows][len];
        int x = 0;
        int j = 0;
        while (x < len) {
            for(int i = 0 ; i< numRows && x < len;i++){
                arry[i][j] = s.charAt(x++);
            }
            j++;
            for ( int i = numRows-2; i> 0 &&  x < len;i--){
                arry[i][j++] = s.charAt(x++);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i =0; i< numRows;i++){
            for( j= 0;j < len;j++){
                if(arry[i][j] != '\0'){
                    sb = sb.append(arry[i][j]);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// "PAYPALISHIRING"\n3\n
// @lcpr case=end

// @lcpr case=start
// "PAYPALISHIRING"\n4\n
// @lcpr case=end

// @lcpr case=start
// "A"\n1\n
// @lcpr case=end

 */

