/**
 * @nc app=nowcoder id=30f9f470390a4a8a8dd3b8e1f8c7a9fa topic=199 question=1975678 lang=MySQL
 * 2026-06-04 12:03:46
 * https://www.nowcoder.com/practice/30f9f470390a4a8a8dd3b8e1f8c7a9fa?tpId=199&tqId=1975678
 * [SQL26] 计算25岁以上和以下的用户数量
 */

/** @nc code=start */

-- 方法一：
select a.age_cut age_cut, count(1) from 
(
    select if(age <25 or age is null,'25岁以下','25岁及以上') as age_cut from user_profile
) a 
group by a.age_cut

-- 方法2
select 
    case 
        when age < 25 or age is null then '25岁以下' 
        else '25岁及以上'
    end as age_cut, 
    count(*) as number 
from user_profile
group by age_cut 

/** @nc code=end */
