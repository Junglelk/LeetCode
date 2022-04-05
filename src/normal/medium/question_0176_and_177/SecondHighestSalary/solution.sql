# Write your MySQL query statement below
# 176
select (select DISTINCT salary from Employee order by salary desc limit 1,1) SecondHighestSalary;
# 177 不同就是177是第 N 高
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    declare T INT;
    set T = N-1;
    RETURN (
        # Write your MySQL query statement below.
        select (select DISTINCT salary from Employee order by salary desc limit T,1) SecondHighestSalary
    );
END;

select getNthHighestSalary(1) from dual;