-- Удаляет товары, количество которых <= 0
create
or replace procedure delete_products()
language 'plpgsql'
as $$
    BEGIN    
            delete from products           
            where products.count <= 0;
    END;
$$;

call delete_products();

-- Удаляет вс записи из таблицы products, если products.price < d_price
create
or replace function f_delete_products(d_price integer)
returns void
language 'plpgsql'
as
$$
    begin
        delete from products
        where products.price < d_price;
    end;
$$;

select f_delete_products(150);
