/**
 * @nc app=nowcoder id=07fde707001048db8342a4be16c7d4b0 topic=383 question=308925 lang=Java
 * 2026-05-27 22:10:07
 * https://www.nowcoder.com/practice/07fde707001048db8342a4be16c7d4b0?tpId=383&tqId=308925
 * [noob6] 【模板】牛牛学加法
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
