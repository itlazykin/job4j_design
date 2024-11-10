create table car_bodies (
	id serial primary key,
	name varchar(20)
);

create table car_engines (
	id serial primary key,
	name varchar(20)
);

create table car_transmissions (
	id serial primary key,
	name varchar(50)
);

create table cars (
	id serial primary key,
	name varchar(20),
	body_id int references car_bodies (id),
	engine_id int references car_engines (id),
	transmission_id int references car_transmissions (id)
);

insert into car_bodies(name) (
values
('Седан'),
('Купе'),
('Хэтчбек'),
('Лифтбек'),
('Кроссовер'),
('AI купе лифтбек')
);

insert into car_engines(name) (
values
('Бензиновый'),
('Дизельный'),
('Газовый'),
('Электрический'),
('AI на свежем воздухе')
);

insert into car_transmissions(name) (
values
('Механическая коробка'),
('Автоматическая коробка'),
('Роботизированная коробка'),
('Вариативная'),
('AI коробка')
);

insert into cars(name,body_id,engine_id,transmission_id) (
values
('Toyota Camry', 1, 1, 2),
('BMW M4', 2, 1, 1),
('Ford Focus', 3, 2, 1),
('Tesla Model S', 1, 4, 2),
('Kia Sportage', 5, 2, 2),
('Volkswagen Golf', 3, 3, 1),
('Audi A5', 4, 1, 3),
('Nissan Leaf', 3, 4, 4),
('BMW',1,3,null),
('VW Amarok',2,null,1)
('AIr car', null, 4, null)
);

--Вывести список всех машин и все привязанные к ним детали.
--Нужно учесть, что каких-то деталей машина может и не содержать.
--В таком случае значение может быть null при выводе
select c.id, c.name as car_name, b.name as body_name, e.name as engine_name, t.name as transmission_name
from cars as c
	left join car_bodies as b
	on c.body_id = b.id
	left join car_engines as e
	on c.engine_id = e.id
	left join car_transmissions as t
	on c.transmission_id = t.id;

--Вывести кузова, которые не используются НИ в одной машине.
select b.name
from car_bodies as b left join cars as c
on b.id = c.body_id
where c.body_id is null;

--Вывести двигатели, которые не используются НИ в одной машине.
select e.name
from car_engines as e left join cars as c
on e.id = c.engine_id
where c.engine_id is null;

--Вывести коробки передач, которые не используются НИ в одной машине.
select t.name
from car_transmissions as t left join cars as c
on t.id = c.transmission_id
where c.transmission_id is null;