-- @author Jungle
-- @since 2022/4/5 18:35
# 编写一个SQL查询来查找收入比经理高的员工。
#
# 以 任意顺序 返回结果表。
Create table If Not Exists Employee
(
    id        int,
    name      varchar(255),
    salary    int,
    managerId int
);
Truncate table Employee;
insert into Employee (id, name, salary, managerId)
values ('1', 'Joe', '70000', '3');
insert into Employee (id, name, salary, managerId)
values ('2', 'Henry', '80000', '4');
insert into Employee (id, name, salary)
values ('3', 'Sam', '60000');
insert into Employee (id, name, salary)
values ('4', 'Max', '90000');

# answer
select a.name Employee
from Employee a,
     Employee b
where a.managerId = b.id
  and a.salary > b.salary;