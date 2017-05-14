
#查询年龄大于蛋蛋1的年龄的学生姓名和年龄
/*
select studentName,age
from student
where age > (select age from student where studentname = '蛋蛋1');
*/

#查询年龄大于蛋蛋1并且大于蛋蛋2的年龄的学生姓名和年龄
/*
select studentName,age
from student
where age > all (select age from student where studentname = '蛋蛋1' or studentname = '蛋蛋2');
*/

#查询年龄在蛋蛋1和蛋蛋2的年龄之间的学生姓名和年龄
/*
select studentName,age
from student
where age in (select age from student where studentname = '蛋蛋1' or studentname = '蛋蛋2');
*/

#如果子查询中查询出来的数据不管是一条还是多条，那么数据都存在，所以exists为true
select studentName,age
from student
where exists (select age from student where studentname = '蛋蛋1' or studentname = '蛋蛋2');