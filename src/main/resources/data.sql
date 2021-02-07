

insert into Author (id, name) values (1, 'Alexander Matthius');
insert into Author (id, name) values (2, 'that bloke');

insert into Book (id, title, isbn) values (1, 'The Leopard', '9786564747');
insert into Book (id, title, isbn) values (2, 'Use of the Self', '454345454');

-- insert into Author_Book (author_id, book_id) values (2, 1);
-- insert into Author_Book (author_id, book_id) values (1, 2);

-- ManyToMany, author is owner, book is inverse (mappedBy)
insert into Author_Book (authors_id, books_id) values (2, 1);
insert into Author_Book (authors_id, books_id) values (1, 2);

--insert into Book_Author (authors_id, Book_id) values (2, 1);
--insert into Book_Author (authors_id, Book_id) values (1, 2);
