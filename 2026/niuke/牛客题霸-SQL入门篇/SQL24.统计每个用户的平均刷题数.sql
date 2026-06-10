/**
 * @nc app=nowcoder id=f4714f7529404679b7f8909c96299ac4 topic=199 question=1975676 lang=MySQL
 * 2026-06-03 19:20:04
 * https://www.nowcoder.com/practice/f4714f7529404679b7f8909c96299ac4?tpId=199&tqId=1975676
 * [SQL24] 统计每个用户的平均刷题数
 */

/** @nc code=start */
select u.university as university ,qd.difficult_level as difficult_level,  count(1)/count(distinct q.device_id) as avg_answer_cnt
from user_profile u join question_practice_detail q on u.device_id = q.device_id 
join question_detail qd on q.question_id = qd.question_id 
where u.university = '山东大学' 
group by university,difficult_level 



/** @nc code=end */
