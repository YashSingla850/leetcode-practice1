# Write your MySQL query statement below
select name , sum(t.amount)as balance  from users 
join transactions as t
where users.account = t.account
group by t.account
having balance >=11000
