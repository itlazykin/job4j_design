create table departments (
	id serial primary key,
	name varchar(50)
);

create table employees (
	id serial primary key,
	name varchar(50),
	departments_id int references departments (id)
);

insert into departments(name) (
values
('Департамент финансовой политики'),
('Департамент управления делами и контроля'),
('Департамент налоговой политики'),
('Департамент IT'),
('Департамент продаж')
);

insert into employees(name, departments_id) (
values
('Анастасия', 5),
('Тема', 2),
('Леро', 5),
('Даня', 5),
('Лена', 1),
('Андрей', null),
('Света', null),
('Денис', 4)
);

select * from employees e
		left join departments d on e.departments_id = d.id; -- left

select * from employees e
		right join departments d on e.departments_id = d.id; -- right

select * from employees e
		full join departments d on e.departments_id = d.id; -- full

select * from employees e
        cross join departments d;     -- cross

SELECT d. * FROM departments d
    LEFT JOIN employees e ON d.id = e.departments_id
WHERE e.id IS NULL;         -- департаменты, у которых нет работников


--Используя left и right join написать запросы,
--которые давали бы одинаковый результат (порядок вывода колонок в эти запросах также должен быть идентичный).
select * from departments d
		left join employees e on d.id = e.departments_id;
select * from employees e
		right join departments d on e.departments_id = d.id;

create table teens(
    id serial primary key,
    name varchar(33),
    gender varchar(10)
);

insert into teens(name, gender) (
values
    ('Den', 'male'),
    ('Nasya', 'female'),
    ('Tema', 'male'),
    ('Lero', 'female')
);

--Используя cross join составить все возможные разнополые пары. Исключите дублирование пар вида Вася-Маша и Маша-Вася.
select t1.name, t2.name
from teens as t1
cross join teens as t2
where t1.name < t2.name