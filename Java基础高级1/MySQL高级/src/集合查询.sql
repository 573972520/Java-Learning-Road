#union会去掉重复数据行
/*
select studentname , age from student where age < 30
union
select studentname , age from student where age > 33
*/
#union all会保留全部数据行
select studentname , age from student where age >30
union all
select studentname , age from student where age > 33