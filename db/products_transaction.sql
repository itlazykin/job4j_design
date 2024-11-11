CREATE TABLE products_t
(
	id       SERIAL PRIMARY KEY,
	"name"   VARCHAR(50),
	producer VARCHAR(50),
	"count"  INTEGER DEFAULT 0,
	price    NUMERIC(21,2)
);
INSERT INTO products_t (name, producer, count, price)
VALUES ('product_1', 'producer_1', 3, 50);
INSERT INTO products_t (name, producer, count, price)
VALUES ('product_2', 'producer_2', 15, 32);


-- read committed
begin transaction isolation level read committed;
    select * from products_t;
    update products_t set count = count + 1 where name = 'product_1';
-- Транзакция завершится успешно и внесет изменения, если не будет конфликтов
--   1 | product_1 | producer_1 |     5 | 50.00

-- repeatable read
begin transaction isolation level repeatable read;
    select * from products_t;
    update products_t set count = count + 1 where name = 'product_1';
-- При попытке выполнить это обновление произойдет ошибка,
-- так как другая транзакция уже изменила 'count' у 'product_1'
-- ERROR:  could not serialize access due to concurrent update

-- serializable
begin transaction isolation level serializable;
select sum(count) from products_t;
update products_t set count = 26 where name = 'product_1';
commit;
begin transaction isolation level serializable;
select sum(count) from products_t;
update products_t set count = 30 where name = 'product_2';
commit;
-- ERROR:  could not serialize access due to read/write dependencies among transactions
-- При попытке выполнить последнюю транзакцию возникнет ошибка сериализации,
-- так как данные зависят от других транзакций (read/write dependencies among transactions)