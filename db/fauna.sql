INSERT INTO fauna (name, avg_age, discovery_date)
VALUES 
    ('Goldfish', 15000, '1842-06-10'),
    ('Swordfish', 9000, '1900-03-15'),
    ('Jellyfish', 500, NULL),               
    ('Clownfish', 8000, '1938-12-05'),
    ('Lungfish', 25000, '1859-07-20'),
    ('Salmon', 4000, '1930-09-01'),
    ('Shark', 30000, '1892-01-15'),
    ('Sturgeon', 12000, '1940-05-09'),
    ('Catfish', 6000, '1955-11-30'),
    ('Eel', 15000, '1925-08-19');
	
SELECT * FROM fauna
WHERE name LIKE '%fish%';

SELECT * FROM fauna
WHERE avg_age BETWEEN 10000 AND 21000;

SELECT * FROM fauna
WHERE discovery_date IS NULL;

SELECT * FROM fauna
WHERE discovery_date < '1950-01-01';
