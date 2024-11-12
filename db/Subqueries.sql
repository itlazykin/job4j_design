CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
); 

insert into customers(first_name, last_name, age, country)
values
('Лазыкин', 'Денис', 35, 'РФ'),
('Лазыкина', 'Анастасия', 35, 'РФ'),
('Лазыкин', 'Артем', 11, 'РФ'),
('Лазыкина', 'Лера', 1, 'РФ'),
('Деев', 'Даниил', 11, 'РФ'),
('Аспиринка', 'Оля', 32, 'Украина'),
('Нейропанк', 'Артем', 27, 'Казахстан');

SELECT * FROM customers
WHERE age = (SELECT min(age) FROM customers);

CREATE TABLE orders_s
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders_s(amount, customer_id)
values
    (1000, 1),
    (6900, 2),
	(1500, 3),
	(5000, 7),
	(4000, 5),
    (4500, 6);

SELECT * FROM customers
WHERE id NOT IN (SELECT customer_id FROM orders_s);
