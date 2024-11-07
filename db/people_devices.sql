INSERT INTO devices (name, price)
VALUES
    ('Ноутбук', 8000.00),
    ('Смотрфон', 4000.00),
    ('Планшет', 2000.00),
    ('Умные часы', 1500.00),
    ('Персональный компьютер', 100000.00);

INSERT INTO people (name)
VALUES
    ('Денис'),
    ('Анастасия'),
    ('Артем'),
    ('Валерия'),
    ('Даник');

INSERT INTO devices_people (device_id, people_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 2),
    (1, 3),
    (4, 3),
    (5, 4),
    (2, 5),
    (3, 5);

SELECT AVG(price)
FROM devices;

SELECT p.name, AVG(d.price)
FROM people AS p
INNER JOIN devices_people AS dp
ON p.id = dp.people_id
INNER JOIN devices AS d
ON dp.device_id = d.id
GROUP BY p.name;

SELECT p.name, AVG(d.price)
FROM people AS p
INNER JOIN devices_people AS dp
ON p.id = dp.people_id
INNER JOIN devices AS d
ON dp.device_id = d.id
GROUP BY p.name
HAVING AVG(d.price) > 5000;