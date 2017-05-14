#查询学生的姓名和该学生课程号为005的课程的成绩

#在where子句中指定连接条件
/*
select studentname , score 
from student,grade
where student.studentid = grade.studentid and courseid = '005';
*/

#在from子句中指定连接条件
/*
#左外连接
select studentname , score 
from student left outer join grade on student.studentid = grade.studentid and courseid = '005'
#左外连接查询的作用：保留左边表（student）的所有数据，如果右边表（grade）连接失败了，使用null填充
*/
select studentname , score 
from student left outer join grade on student.studentid = grade.studentid #and中的条件换到where中，那么作用左外连接就不会显示出那些值为null的数据
where courseid = '005'
/*
#右外连接
select studentname , score 
from student left outer join grade on student.studentid = grade.studentid and courseid = '005'
#右外连接查询的作用：保留右边表（grade）的所有数据，如果右边表（student）连接失败了，使用null填充
*/

/*
#内连接查询
select studentname , score 
from student inner join grade on student.studentid = grade.studentid
where courseid = '005'
*/
