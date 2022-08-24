# Write your MySQL query statement below
select t1.name as Employee from employee as t1 , employee as t2
where  t2.id = t1.managerId && t1.salary > t2.salary;