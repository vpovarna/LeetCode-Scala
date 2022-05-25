use db;
drop table if exists Products;
create table if not exists Products(product_id INT, low_fats ENUM('Y', 'N'), recyclable ENUM('Y', 'N'), primary key (product_id));

insert into Products values (0, 'Y', 'N');
insert into Products values (1, 'Y', 'Y');
insert into Products values (2, 'N', 'Y');
insert into Products values (3, 'Y', 'Y');
insert into Products values (4, 'N', 'N');

select * from Products;

select product_id from Products where low_fats = 'Y' AND recyclable = 'Y';
