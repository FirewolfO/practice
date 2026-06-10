/**
 * @nc app=nowcoder id=55f3d94c3f4d47b69833b335867c06c1 topic=199 question=1975673 lang=MySQL
 * 2026-06-02 22:49:46
 * https://www.nowcoder.com/practice/55f3d94c3f4d47b69833b335867c06c1?tpId=199&tqId=1975673
 * [SQL21] 浙江大学用户题目回答情况
 */

/** @nc code=start */

select q.device_id device_id , question_id, result 
from question_practice_detail q
join user_profile u 
where q.device_id = u.device_id 
and u.university = '浙江大学';

/** @nc code=end */
