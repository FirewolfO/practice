/**
 * @nc app=nowcoder id=5400df085a034f88b2e17941ab338ee8 topic=199 question=1975675 lang=MySQL
 * 2026-06-03 17:21:46
 * https://www.nowcoder.com/practice/5400df085a034f88b2e17941ab338ee8?tpId=199&tqId=1975675
 * [SQL23] 统计每个学校各难度的用户平均刷题数
 */

/** @nc code=start */
select u.university as university ,qd.difficult_level as difficult_level,  count(1)/count(distinct q.device_id) as avg_answer_cnt
from user_profile u join question_practice_detail q on u.device_id = q.device_id 
join question_detail qd on q.question_id = qd.question_id 
group by university,difficult_level

/** @nc code=end */
