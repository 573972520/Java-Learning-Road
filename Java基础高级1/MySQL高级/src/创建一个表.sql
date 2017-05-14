create table student(
	id int primary key auto_increment ,   
	name varchar(30) not null ,
	gender varchar(10) not null default '男' ,
	age int 
);