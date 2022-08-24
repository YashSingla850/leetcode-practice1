# Write your MySQL query statement below
select t1.id
from Weather as t1 , Weather as t2
where t1.temperature > t2.temperature && 
to_days(t1.recordDate) -to_days(t2.recordDate) =1;