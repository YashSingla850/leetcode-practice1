# Write your MySQL query statement below
select Department.name as Department , Employee.name as employee , Employee.salary as salary from Employee,
Department  
where  Employee.departmentId = Department.id
and  Employee.salary = (select max(salary) from Employee where Employee.departmentId = Department.id);