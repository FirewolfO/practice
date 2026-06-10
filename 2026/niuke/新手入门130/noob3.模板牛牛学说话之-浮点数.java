/**
 * @nc app=nowcoder id=7c3bf58fac1a4eb69fa32c2d2c379bac topic=383 question=308924 lang=Java
 * 2026-05-27 22:01:02
 * https://www.nowcoder.com/practice/7c3bf58fac1a4eb69fa32c2d2c379bac?tpId=383&tqId=308924
 * [noob3] 【模板】牛牛学说话之-浮点数
 */

/** @nc code=start */

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}

/** @nc code=end */
