CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,  
    name VARCHAR(100),    
    country VARCHAR(50)            
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,      
    title VARCHAR(200),     
    author_id INT REFERENCES authors(author_id),  
    published_year INT               
);

INSERT INTO authors (name, country) VALUES 
    ('Лев Толстой', 'Россия'),
    ('Федор Достоевский', 'Россия'),
    ('Александр Пушкин', 'Россия'),
    ('Михаил Булгаков', 'Россия'),
    ('Джордж Оруэлл', 'Великобритания'),
    ('Эрнест Хемингуэй', 'США');

INSERT INTO books (title, author_id, published_year) VALUES 
    ('Война и мир', 1, 1869),
    ('Анна Каренина', 1, 1877),
    ('Преступление и наказание', 2, 1866),
    ('Братья Карамазовы', 2, 1880),
    ('Евгений Онегин', 3, 1833),
    ('Капитанская дочка', 3, 1836),
    ('Мастер и Маргарита', 4, 1967),
    ('Собачье сердце', 4, 1925),
    ('1984', 5, 1949),
    ('Скотный двор', 5, 1945),
    ('Старик и море', 6, 1952),
    ('По ком звонит колокол', 6, 1940);

SELECT 
    b.title AS Название_книги, 
    a.name AS Имя_автора
FROM 
    books AS b
INNER JOIN 
    authors AS a ON b.author_id = a.author_id;

SELECT 
    a.name AS Имя_автора, 
    COUNT(b.book_id) AS Количество_книг
FROM 
    authors AS a
INNER JOIN 
    books AS b ON a.author_id = b.author_id
GROUP BY 
    a.name;

SELECT 
    b.title AS Название_книги, 
    a.name AS Имя_автора, 
    a.country AS Страна_автора
FROM 
    books AS b
INNER JOIN 
    authors AS a ON b.author_id = a.author_id
WHERE 
    b.published_year > 1850;
