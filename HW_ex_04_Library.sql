-- Задание 4.	Используя MySQL Workbench переписать базу данных так, 
-- чтобы одну книгу могли б написать несколько авторов, также один автор может написать несколько книг. 
-- Реализовать связь многие ко многим.


DROP DATABASE IF EXISTS library_hw;

CREATE DATABASE library_hw;

USE library_hw;

CREATE TABLE author
(
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    last_name varchar(255) DEFAULT NULL,
    PRIMARY KEY ( id )
);


CREATE TABLE book
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY(id)
);

CREATE TABLE author_book
(
	id BIGINT NOT NULL AUTO_INCREMENT,
    author_id BIGINT,
    book_id BIGINT,
    PRIMARY KEY(id),
    FOREIGN KEY(author_id) REFERENCES author(id),
    FOREIGN KEY(book_id) REFERENCES book(id)
);
    
	


INSERT INTO author(name, last_name)
VALUES
    ('Franz', 'Kafka'),
    ('Charles', 'Dickens'),
    ('Herman', 'Melville'),
    ('Clive', 'Lewis'),
    ('Terry', 'Pratchett'),
    ('Neil', 'Gaiman'),
    ('Илья', 'Ильф'),
    ('Евгений', 'Петров');


INSERT INTO book(name)
VALUES
    ('The Trial'),
    ('The Metamorphosis'),
    ('A Tale of Two Cities'),
    ('A Christmas Carol'),
    ('Oliver Twist'),
    ('Typee: A Peep at Polynesian Life'),
    ('Mardi: and a Voyage Thither'),
    ('The Great Divorce'),
    ('The Four Loves'),
    ('The Chronicles of Narnia'),
    ('Good Omens'),
    ('Двенадцать стульев');
    
    INSERT INTO author_book(author_id, book_id)
    VALUES
		(1, 1),
		(1, 2),
		(2, 3),
		(2, 4),
		(2, 5),
		(3, 6),
		(3, 7),
		(4, 8),
		(4, 9),
		(4, 10),
		(5, 11),
		(6, 11),
		(7, 12),
		(8, 12);

-- ************************************************

select * from library_hw.author;

select * from library_hw.book;

select * from Library_hw.author_book;