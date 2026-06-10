/**
 * @nc app=nowcoder id=847373e2fe8d47b4a2c294bdb5bda8b6 topic=199 question=1975680 lang=MySQL
 * 2026-06-09 14:38:10
 * https://www.nowcoder.com/practice/847373e2fe8d47b4a2c294bdb5bda8b6?tpId=199&tqId=1975680
 * [SQL28] 计算用户8月每天的练题数量
 */

/** @nc code=start */

select day(date) as day, count(question_id) as question_cnt
from question_practice_detail 
where month(date) = '8' and year(date) = '2021'
group by day  

/** @nc code=end */
