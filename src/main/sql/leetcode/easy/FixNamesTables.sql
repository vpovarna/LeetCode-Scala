USE db;
DROP TABLE IF EXISTS Users;

create table if not exists Users (user_id Int, name varchar(255));

insert into Users values (1, "aLice");
insert into Users values (2, "bOB");

select * from Users;

select user_id, concat(upper(substr(name, 1, 1)), lower(substr(name, 2))) as name from Users order by user_id;