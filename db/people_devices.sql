insert into devices (name, price)
values
    ('Ноутбук', 8000.00),
    ('Смотрфон', 4000.00),
    ('Планшет', 2000.00),
    ('Умные часы', 1500.00),
    ('Персональный компьютер', 100000.00);

insert into people (name)
values
    ('Денис'),
    ('Анастасия'),
    ('Артем'),
    ('Валерия'),
    ('Даник');

insert into devices_people (device_id, people_id)
values
    (1, 1),
    (2, 1),
    (3, 2),
    (1, 3),
    (4, 3),
    (5, 4),
    (2, 5),
    (3, 5);

/*
Используя агрегатные функции вывести среднюю цену устройств
*/
select avg(price)
from devices;

/*
Используя группировку вывести для каждого человека среднюю цену его устройств
*/
select p.name, avg(d.price)
from people as p
inner join devices_people as dp
on p.id = dp.people_id
inner join devices as d
on dp.device_id = d.id
group by p.name;

/*
Дополнить запрос п.4. условием, что средняя стоимость устройств должна быть больше 5000
*/
select p.name, avg(d.price)
from people as p
inner join devices_people as dp
on p.id = dp.people_id
inner join devices as d
on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;