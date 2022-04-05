# Write your MySQL query statement below
select FirstName, LastName, City, State
from Person P
         left join Address a on P.PersonId = a.PersonId;