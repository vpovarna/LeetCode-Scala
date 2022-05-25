use db;
drop table if exists Customers;
drop table if exists Orders;

create table if not exists Customers(id INT, name VARCHAR(255), primary key (id));
create table if not exists Orders(id INT, customerId INT, primary key (id));

insert into Customers values (1, "Joe");
insert into Customers values (2, "Henry");
insert into Customers values (3, "Sam");
insert into Customers values (4, "Max");

insert into Orders values (1, 3);
insert into Orders values (2, 1);

-- # https://tableplus.com/blog/2018/09/a-beginners-guide-to-seven-types-of-sql-joins.html
select name as Customers from Customers left join Orders on Customers.id = Orders.customerId where Orders.customerId is Null;