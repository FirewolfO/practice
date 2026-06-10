/**
 * @nc app=nowcoder id=ae44b2b78525417b8b2fc2075b557592 topic=199 question=1975679 lang=MySQL
 * 2026-06-04 19:00:00
 * https://www.nowcoder.com/practice/ae44b2b78525417b8b2fc2075b557592?tpId=199&tqId=1975679
 * [SQL27] 查看不同年龄段的用户明细
 */

/** @nc code=start */
select device_id,gender,
case 
    when age < 20 then '20岁以下' 
    when age <= 24 then '20-24岁' 
    when age is not null then '25岁及以上' 
    else '其他'
end as age_cut 
from user_profile


/** @nc code=end */
