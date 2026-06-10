/**
 * @nc app=nowcoder id=ddbcedcd9600403296038ee44a172f2d topic=199 question=1975671 lang=MySQL
 * 2026-05-28 09:41:32
 * https://www.nowcoder.com/practice/ddbcedcd9600403296038ee44a172f2d?tpId=199&tqId=1975671
 * [SQL19] 分组过滤练习题
 */

/** @nc code=start */
select university,avg(question_cnt) as avg_question_cnt,avg(answer_cnt) as avg_answer_cnt from user_profile group by university
having avg_question_cnt < 5 or avg_answer_cnt < 20


/** @nc code=end */
