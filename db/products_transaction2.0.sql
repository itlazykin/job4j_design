create table products (
    id       serial primary key,
    "name"   varchar(50),
    producer varchar(50),
    "count"  integer default 0,
    price    integer
);

insert into
    products ("name", producer, "count", price)
values
    ('product_1', 'producer_1', 3, 50),
    ('product_2', 'producer_2', 15, 32),
    ('product_3', 'producer_3', 8, 115);

begin transaction;
insert into products ("name", producer, "count", price) values ('product_4', 'producer_4', 153, 404);
commit transaction;

select * from products;

begin transaction;
delete from products;
drop table products;
rollback transaction;

select * from products;

begin transaction;
insert into products ("name", producer, "count", price) values ('product_5', 'producer_5', 100, 200);
savepoint first_sp;
delete from products where "count" = 8;
update products set "name" = 'product_4' where producer = 'producer_4';
select * from products;
rollback to first_sp;
select * from products;
commit transaction;