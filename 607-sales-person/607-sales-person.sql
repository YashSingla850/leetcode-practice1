# Write your MySQL query statement below
select sp.name from salesPerson as sp
left join orders as o
on sp.sales_id = o.sales_id
left join company as c
on o.com_id = c.com_id
group by sp.name
having count(order_id) =0  or sum(c.name='red') =0;
