/**
 * @nc app=nowcoder id=95d9922b1e2a49de80daa491889969ee topic=199 question=1975667 lang=MySQL
 * 2026-05-26 15:42:25
 * https://www.nowcoder.com/practice/95d9922b1e2a49de80daa491889969ee?tpId=199&tqId=1975667
 * [SQL15] 查看学校名称中含北京的用户
 */

/** @nc code=start */
select device_id,age,university from  user_profile 
where university like '%北京%';

/** @nc code=end */
