/**
 * @nc app=nowcoder id=88aa923a9a674253b861a8fa56bac8e5 topic=199 question=1975674 lang=MySQL
 * 2026-06-02 22:54:19
 * https://www.nowcoder.com/practice/88aa923a9a674253b861a8fa56bac8e5?tpId=199&tqId=1975674
 * [SQL22] 统计每个学校的答过题的用户的平均答题数
 */

/** @nc code=start */
select university, count(1)/count(distinct u.device_id) as avg_answer_cnt
from user_profile u
join question_practice_detail q 
on u.device_id = q.device_id
group by university 

/** @nc code=end */
