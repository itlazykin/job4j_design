create table company(
	id integer not null,
	name character varying,
	constraint company_pkey primary key(id)
);

create table person(
	id integer not null,
	name character varying,
	company_id integer references company(id),
	constraint person_key primary key(id)
);

INSERT INTO company (id, name) VALUES
(1, 'ООО "ТехИнновации"'),
(2, 'ЗАО "ИнтерСвязь"'),
(3, 'АО "АльфаТехнологии"'),
(4, 'ООО "МегаполисТрейд"'),
(5, 'ЗАО "ГлобалСервис"'),
(6, 'ООО "ЭкоТранс"'),
(7, 'ООО "АгроТех"'),
(8, 'АО "Энергомаш"'),
(9, 'ЗАО "МедиаГрупп"'),
(10, 'ООО "СофтСистемы"');

INSERT INTO person (id, name, company_id) VALUES
(1, 'Алексей Иванов', 1),
(2, 'Мария Петрова', 2),
(3, 'Иван Сидоров', 3),
(4, 'Ольга Смирнова', 4),
(5, 'Дмитрий Кузнецов', 5),
(6, 'Екатерина Федорова', 6),
(7, 'Сергей Крылов', 7),
(8, 'Наталья Орлова', 8),
(9, 'Андрей Тарасов', 9),
(10, 'Юлия Морозова', 10),
(11, 'Владимир Жуков', 1),
(12, 'Анна Попова', 2),
(13, 'Константин Лебедев', 3),
(14, 'Елена Захарова', 4),
(15, 'Максим Волков', 5),
(16, 'Виктория Белова', 6),
(17, 'Михаил Романов', 7),
(18, 'Алёна Котова', 8),
(19, 'Игорь Павлов', 9),
(20, 'Татьяна Соколова', 10);

--имена всех person, которые не состоят в компании с id = 5
SELECT name 
FROM person 
WHERE company_id <> 5;

--название компании для каждого человека
SELECT person.name AS pn, company.name AS cn
FROM person
JOIN company ON person.company_id = company.id;

--выбрать название компании с максимальным количеством человек + количество человек в этой компании.
--Нужно учесть, что таких компаний может быть несколько
WITH company_counts AS (
    SELECT 
        company.name AS cn, 
        COUNT(person.id) AS pc
    FROM 
        company
    JOIN 
        person ON company.id = person.company_id
    GROUP BY 
        company.name
)
    SELECT 
        cn, 
        pc
    FROM 
        company_counts
	WHERE 
   		 pc = (SELECT MAX(pc) FROM company_counts);