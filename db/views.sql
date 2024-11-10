create view available_books_for_students as
select 
    st.name as student_name,
    bk.name as book_name,
    au.name as author_name
from 
    students st
cross join 
    books bk
join 
    authors au on bk.author_id = au.id
left join 
    orders ord on ord.book_id = bk.id and ord.student_id = st.id
where 
    ord.id is null;

select * from available_books_for_students order by student_name, author_name, book_name;
