create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

-- Триггер срабатывает после вставки данных, для любого товара и насчитывает налог на товар 
-- Срабатывает на запрос (statement уровень)
create or replace function tax_after() returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.18
        where id = (select id from inserted);
        return new;
    END
$$ LANGUAGE 'plpgsql';

create trigger product_tax_after
    after insert
    on products
    referencing new table as inserted
    for each statement
    execute procedure tax_after();

-- Триггер срабатывает до вставки данных и насчитывает налог на товар 
-- Используем row уровень.
create or replace function tax_before() returns trigger as
$$
    BEGIN
        new.price = new.price * 1.18
        return new;
    END
$$ LANGUAGE 'plpgsql';

create trigger product_tax_before
    before insert
    on products
    for each row
    execute procedure tax_before();

-- триггер на row уровне, который сразу после вставки продукта в таблицу products, 
-- будет заносить имя, цену и текущую дату в таблицу history_of_price. 
create or replace function history_price_log() returns trigger as
$$
BEGIN
        insert into history_of_price(name, price, date)
		values (new.name, new.price, CURRENT_TIMESTAMP);
        return new;
    END
$$ LANGUAGE 'plpgsql';

create trigger history_price_trigger
	before insert 
	on products
	for each row
	execute procedure history_price_log();