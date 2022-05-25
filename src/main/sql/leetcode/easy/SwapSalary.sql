use db;

create table if not exists Salary
(
    id     Int,
    name   VARCHAR(255),
    sex    ENUM ('f', 'm'),
    salary int
);

insert into Salary VALUES (1, 'A', 'f', 2500);
insert into Salary VALUES (2, 'B', 'm', 1500);
insert into Salary VALUES (3, 'C', 'f', 5500);
insert into Salary VALUES (4, 'D', 'm', 500);

select *
from Salary;

update Salary set sex = if(sex = 'm', 'f', 'm');
