begin;

declare rcp scroll cursor for
select * from products order by desc;

fetch 20 from rcp;

close rcp;

commit;

begin;

declare cp scroll cursor for
select * from products;

fetch last from cp;

move backward 6 from cp;

fetch next from cp;

move backward 9 from cp;

fetch next from cp;

move backward 6 from cp;

fetch next from cp;

fetch prior from cp;

close cp;

commit;