CREATE TABLE users (
id serial PRIMARY KEY,
user_name VARCHAR(32), 
sex BOOLEAN, 
birthday DATE
);

INSERT INTO users (user_name, sex, birthday) VALUES ('Den', true, '1989-08-11');

UPDATE users SET user_name = 'ZloDen';

DELETE FROM users;