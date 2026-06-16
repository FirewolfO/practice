/*
 * @lc app=leetcode.cn id=12 lang=java
 * @lcpr version=30204
 *
 * [12] 整数转罗马数字
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String intToRoman(int num) {
        char[] fuhao10 = new char[]{'M','C','X','I'};
        char[] fuhao5 = new char[]{'D','L','V'};
        int[] nums10 = new int[]{1000,100,10,1}; 
   
        StringBuffer sb = new StringBuffer();
      for (int i = 0; num != 0 && i < fuhao10.length; i++){
            int count = num / nums10[i]; 
            num = num - nums10[i] * count;
            if (count == 0){
                continue;
            }
            if(i==0){
                for (int j = 0; j< count;j++){
                    sb = sb.append(fuhao10[i]);
                }
                continue;
            }
            if(count == 5){
                sb = sb.append(fuhao5[i-1]);
            }else if(count == 4){
                sb= sb.append(fuhao10[i]).append(fuhao5[i-1]);
            }else if (count == 9){
                sb = sb.append(fuhao10[i]).append(fuhao10[i-1]);
            }else{ 
                int x = count / 5; 
                int y = count % 5;
                for (int j = 0; j < x ;j ++){
                    sb = sb.append(fuhao5[i-1]);
                }
                for (int j = 0;j < y;j++){
                    sb = sb.append(fuhao10[i]);
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end



/*
// @lcpr case=start
// 3749\n
// @lcpr case=end

// @lcpr case=start
// 58\n
// @lcpr case=end

// @lcpr case=start
// 1994\n
// @lcpr case=end

 */

