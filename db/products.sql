CREATE TABLE type(
	ID serial PRIMARY KEY,
	name varchar(50)
);

CREATE TABLE product(
	ID serial primary key,
	name varchar(50),
	type_id int REFERENCES type(id),
	expired_date date,
	price float
);

INSERT INTO type(name) 
VALUES
	('Сыр'),
	('Молоко'),
	('Мясо'),
	('Овощи'),
	('Мороженное');

INSERT INTO product(name, type_id,expired_date, price)
VALUES
('сыр плавленный', 1, '2024-11-15', 30.3),
('сыр пармезан', 1, '2024-12-20', 28.1),
('сыр моцарелла', 1, '2024-11-20', 50.7),
('молоко сухое', 2, '2025-02-01', 25.3),
('молоко сгущеное', 2, '2025-11-10', 29.3),
('молоко цельное', 2, '2025-11-10', 12.3),
('курица', 3, '2024-11-01', 32.3),
('свинина', 3, '2024-11-10', 42.3),
('говядина', 3, '2024-12-01', 50.7),
('огурец', 4, '2024-11-01', 2.2),
('помидор', 4, '2024-11-10', 7.3),
('кабачок', 4, '2025-01-01', 9.4),
('баклажан', 4, '2024-12-11', 2.0),
('картофель', 4, '2024-11-11', 3.3),
('капуста пекинская', 4, '2024-11-10', 1.5),
('капуста белокочанная', 4, '2024-11-01', 9.4),
('лук белый', 4, '2024-12-11', 3.3),
('лук розовый', 4, '2024-12-01', 4.1),
('чеснок', 4, '2025-01-11', 3.2),
('мороженое мясо курицы', 5, '2024-11-15', 35.5),
('мороженое в рожке', 5, '2024-11-15', 6.5),
('мороженое мясо свинины', 5, '2024-11-15', 45.5)

/* 
запрос получение всех продуктов с типом "СЫР"
*/	
SELECT pr.name 
FROM product AS pr
JOIN TYPE AS tp
ON pr.type_id = tp.id
GROUP BY pr.name
HAVING pr.name LIKE '%сыр%'

/* 
запрос получения всех продуктов, у кого в имени есть слово "мороженое"
*/
SELECT name 
FROM product
WHERE name LIKE '%мороженое%'

/*
запрос, который выводит все продукты, срок годности которых уже истек
*/
SELECT name
FROM product AS pr
WHERE pr.expired_date <= current_timestamp

/* 
запрос, который выводит самый дорогой продукт
*/
SELECT pr.name, pr.price
FROM product AS pr
WHERE pr.price = (SELECT MAX(price) FROM product)

/*
запрос, который выводит для каждого типа количество продуктов к нему принадлежащих
*/
SELECT tp.name, COUNT(pr.name)
FROM product AS pr
JOIN TYPE AS tp
ON pr.type_id = tp.id
GROUP BY tp.name

/*
запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
*/
SELECT pr.name
FROM product AS pr
JOIN TYPE AS tp
ON pr.type_id = tp.id
WHERE tp.name IN ('сыр', 'молоко')

/*
запрос, который выводит тип продуктов, которых осталось меньше 10 штук
*/
SELECT tp.name, COUNT(pr.name)
FROM product AS pr
JOIN TYPE AS tp
ON pr.type_id = tp.id
GROUP BY tp.name
HAVING COUNT(pr.name) < 10

/*
все продукты и их тип
*/
SELECT pr.name AS Наименование_продукта, tp.name AS Наименование_типа_товара
FROM product AS pr
JOIN TYPE AS tp
ON pr.type_id = tp.id
