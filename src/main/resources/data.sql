drop table BOOK;
create table book(id bigint auto_increment, AUTHOR varchar(255), TITLE varchar(255), YEAR_OF_PUBLICATION integer);
INSERT INTO BOOK (id, author, title, year_of_publication) VALUES
(101L, 'Colleen Hoover', 'It Ends with Us', 2016),
(102L , 'Delia Owens', Where the Crawdads Sing, 2021),
(103L, 'Colleen Hoover', 'Verity', 2022),
(104L, 'Taylor Jenkins Reid', 'The Seven Husbands of Evelyn Hugo', 2018),
(105L, 'James Clear', 'Atomic Habits: An Easy & Proven Way to Build Good Habits & Break Bad Ones', 2018);

