/**
 * @nc app=nowcoder id=979b1a5a16d44afaba5191b22152f64a topic=199 question=1975677 lang=MySQL
 * 2026-06-04 11:56:41
 * https://www.nowcoder.com/practice/979b1a5a16d44afaba5191b22152f64a?tpId=199&tqId=1975677
 * [SQL25] 查找山东大学或者性别为男生的信息
 */

/** @nc code=start */

select device_id,gender,age,gpa 
from user_profile
where university = '山东大学' 
union all 
select device_id,gender,age,gpa 
from user_profile
where gender = 'male';
 

/** @nc code=end */
