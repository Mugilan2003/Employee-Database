Use crudopp;
create table EmployeeDatabase(
eId int primary key auto_increment,
eName varchar(30),
eAge int,
job_desc varchar(30) default'Unassigned',
salary int default '0',
branch varchar(30) default 'Unassigned'
);
select*from EmployeeDatabase;
