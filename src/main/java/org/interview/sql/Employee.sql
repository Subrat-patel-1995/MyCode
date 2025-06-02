1.
select MAX(salary) from employee.

2.2nd Highest

select max(salary) from employee where salary < (select max(salary) from employee) ;

select salary from employee order by salary desc limit 1 offset 1;
--using subQuery
select salary from (select distinct salary from employee order by salary desc limit 2) as result order by salary limit 1;




3. 4th
--using subQuery

select salary from (select distinct salary from employee order by salary desc limit 4) as result order by salary limit 1;

--use cte