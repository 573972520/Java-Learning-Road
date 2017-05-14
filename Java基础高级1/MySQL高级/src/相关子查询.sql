#查询至少有一门课程成绩大于90分的学生的姓名
select  studentname
from student s
where exists ( select * from grade g where s.studentid = g.studentid and score >90 );
