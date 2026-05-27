/**
 * @nc app=nowcoder id=df9ee533ef9544bfa382203c812d9b55 topic=383 question=308923 lang=Go
 * 2026-05-26 16:50:21
 * https://www.nowcoder.com/practice/df9ee533ef9544bfa382203c812d9b55?tpId=383&tqId=308923
 * [noob2] 【模板】牛牛学说话之-整数
 */

/** @nc code=start */

package main

import (
	"fmt"
)

func main() {
	a := 0
	for {
		n, _ := fmt.Scan(&a)
		if n == 0 {
			break
		} else {
			fmt.Printf("%d\n", a)
		}
	}
}

/** @nc code=end */
