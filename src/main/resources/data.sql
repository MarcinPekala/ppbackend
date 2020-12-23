drop table BOOK;
create table book(id bigint auto_increment, AUTHOR varchar(255), TITLE varchar(255), YEAR_OF_PUBLICATION integer);
INSERT INTO BOOK (id, author, title, year_of_publication) VALUES
(101L, 'Barack Obama', 'A Promised Land', 2020),
(102L , 'Bill O''Neill', 'Interesting Stories For Curious People: A Collection of Fascinating Stories About History, Science, Pop Culture and Just About Anything Else You Can Think of', 2020),
(103L, 'Matthew McConaughey', 'Greenlights', 2020),
(104L, 'M Prefontaine', 'Difficult Riddles For Smart Kids: 300 Difficult Riddles And Brain Teasers Families Will Love (Books for Smart Kids)', 2017),
(105L, 'Glennon Doyle', 'Untamed', 2020);

