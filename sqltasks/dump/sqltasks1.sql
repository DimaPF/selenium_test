\c sqltasks1
CREATE TABLE posts(
 PostID SERIAL PRIMARY KEY, 
 Title VARCHAR(50), 
 Text VARCHAR(150), 
 PostDate Date, 
 AuthorID SERIAL
);

CREATE TABLE Authors(
 AuthorID SERIAL PRIMARY KEY, 
 Name VARCHAR(30)
);

CREATE TABLE Tags(
 TagID SERIAL PRIMARY KEY, 
 TagName VARCHAR(30)
);

ALTER TABLE posts ADD FOREIGN KEY (AuthorID) REFERENCES Authors (AuthorID);

CREATE TABLE Tag_for_post(
 TagID INT NOT NULL, 
 PostID INT NOT NULL,
 PRIMARY KEY (TagID, PostID),
 FOREIGN KEY (TagID) REFERENCES Tags(TagID), 
 FOREIGN KEY (PostID) REFERENCES posts(PostID)
);

INSERT INTO Authors(AuthorID, Name) VALUES (1, 'Alex');
INSERT INTO Authors(AuthorID, Name) VALUES (2, 'Bob');
INSERT INTO Authors(AuthorID, Name) VALUES (3, 'Dan');
INSERT INTO Authors(AuthorID, Name) VALUES (4, 'Elena');
INSERT INTO Authors(AuthorID, Name) VALUES (5, 'Hasan');
INSERT INTO Authors(AuthorID, Name) VALUES (6, 'Adolf');
INSERT INTO Authors(AuthorID, Name) VALUES (7, 'Igor');

INSERT INTO Tags(TagID, TagName) VALUES (0, '');
INSERT INTO Tags(TagID, TagName) VALUES (1, 'FIRST');
INSERT INTO Tags(TagID, TagName) VALUES (2, 'HEIL');
INSERT INTO Tags(TagID, TagName) VALUES (3, 'FRIDAY');

INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (1, 'Hello World!', 'Hi to all! My first message', '2018-01-25', 1);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (2, 'Second', 'Second', '2018-01-25', 1);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (3, 'Heil!', 'Mein Kampf', '1935-05-11', 6);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (4, 'Salam', 'Post about muslims', '2016-11-03', 5);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (5, 'Best day', 'Friday will be the best day', '2018-09-13', 7);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (6, 'Blabla', 'Some text', '2018-09-14', 5);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (7, 'Ein Folk', 'Das Staatliche Hofbräuhaus am Platzl ist ein Bierpalast in der Münchner Altstadt am Platzl.', '1932-03-25', 6);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (8, 'Monday', 'Hard day', '2018-09-17', 7);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (9, 'True story', 'a lot of mems URLs', '2018-09-03', 1);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (10, 'Boby stories', 'Once Upon a Time tells the story', '2018-03-08', 2);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (11, 'New Year Party!', 'Happy New Year... bla-bla', '2017-12-31', 2);
INSERT INTO posts (PostID, Title, Text, PostDate, AuthorID) VALUES (12, 'Holiday', 'Best wishes... ', '2018-03-08', 3);

INSERT INTO Tag_for_post(PostID, TagID) VALUES(1, 1);
INSERT INTO Tag_for_post(PostID, TagID) VALUES(1, 3);
INSERT INTO Tag_for_post(PostID, TagID) VALUES(2, 0);
INSERT INTO Tag_for_post(PostID, TagID) VALUES(3, 2);
INSERT INTO Tag_for_post(PostID, TagID) VALUES(4, 1);
INSERT INTO Tag_for_post(PostID, TagID) VALUES(5, 3);
INSERT INTO Tag_for_post(PostID, TagID) VALUES(6, 0);