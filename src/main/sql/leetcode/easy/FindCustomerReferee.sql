use db;
drop table if exists Customer;
create table if not exists Customer(id INT, name VARCHAR(255), referee_id int, primary key (id));

insert into Customer values (1, "Will", null);
insert into Customer values (2, "Jane", null);
insert into Customer values (3, "Alex", 2);
insert into Customer values (4, "Bill", null);
insert into Customer values (5, "Zack", 1);
insert into Customer values (6, "Mark", 2);

select * from Customer;

select name from Customer where referee_id != 2 or referee_id is null;
