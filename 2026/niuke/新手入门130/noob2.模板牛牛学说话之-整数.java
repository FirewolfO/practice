/**
 * @nc app=nowcoder id=df9ee533ef9544bfa382203c812d9b55 topic=383 question=308923 lang=Java
 * 2026-05-26 16:50:40
 * https://www.nowcoder.com/practice/df9ee533ef9544bfa382203c812d9b55?tpId=383&tqId=308923
 * [noob2] 【模板】牛牛学说话之-整数
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
            System.out.println(a);
        }
    }
}

/** @nc code=end */
