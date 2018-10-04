\c sqltasks2

CREATE TABLE Users(
 UserID SERIAL PRIMARY KEY, 
 UserName VARCHAR(30),
 UserAge INT
);

CREATE TABLE Twitts(
 TwittID SERIAL PRIMARY KEY, 
 Text VARCHAR(150), 
 TwittDate Date, 
 UserID INT NOT NULL,
 FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE Comments(
 CommentID SERIAL PRIMARY KEY, 
 CommentText VARCHAR(150),
 CommentDate TIMESTAMP,	
 TwittID INT NOT NULL,
 UserID INT NOT NULL,
 FOREIGN KEY (TwittID) REFERENCES Twitts(TwittID),
 FOREIGN KEY (UserID) REFERENCES Users(UserID)
);

CREATE TABLE Followers(
 UserID INT NOT NULL, 
 FollowingID INT NOT NULL,
 PRIMARY KEY (UserID, FollowingID),
 FOREIGN KEY (UserID) REFERENCES Users(UserID), 
 FOREIGN KEY (FollowingID) REFERENCES Users(UserID)
);

INSERT INTO Users(UserID, UserName, UserAge) VALUES (1, 'Alex', 33);
INSERT INTO Users(UserID, UserName, UserAge) VALUES (2, 'Bob', 37);
INSERT INTO Users(UserID, UserName, UserAge) VALUES (3, 'Dan', 45);
INSERT INTO Users(UserID, UserName, UserAge) VALUES (4, 'Elena', 18);
INSERT INTO Users(UserID, UserName, UserAge) VALUES (5, 'Hasan', 24);
INSERT INTO Users(UserID, UserName, UserAge) VALUES (6, 'Adolf', 129);
INSERT INTO Users(UserID, UserName, UserAge) VALUES (7, 'Igor', 30);

INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (1, 'Hi to all! My first message', '2018-01-25', 1);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (2, 'Second', '2018-01-25', 1);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (3, 'Mein Kampf', '1935-05-11', 6);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (4, 'Post about muslims', '2016-11-03', 5);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (5, 'Friday will be the best day', '2018-09-13', 7);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (6, 'Some text', '2018-09-14', 5);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (7, 'Das Staatliche Hofbräuhaus am Platzl ist ein Bierpalast in der Münchner Altstadt am Platzl.', '1932-03-25', 6);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (8, 'Hard day', '2018-09-17', 7);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (9, 'a lot of mems URLs', '2018-09-03', 1);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (10, 'Once Upon a Time tells the story', '2018-03-08', 2);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (11, 'Happy New Year... bla-bla', '2017-12-31', 2);
INSERT INTO Twitts (TwittID, Text, TwittDate, UserID) VALUES (12, 'Best wishes... ', '2018-03-08', 3);

INSERT INTO Followers(UserID, FollowingID) VALUES (1, 6);
INSERT INTO Followers(UserID, FollowingID) VALUES (1, 7);
INSERT INTO Followers(UserID, FollowingID) VALUES (2, 6);
INSERT INTO Followers(UserID, FollowingID) VALUES (3, 6);
INSERT INTO Followers(UserID, FollowingID) VALUES (3, 7);
INSERT INTO Followers(UserID, FollowingID) VALUES (4, 6);
INSERT INTO Followers(UserID, FollowingID) VALUES (5, 4);
INSERT INTO Followers(UserID, FollowingID) VALUES (5, 2);
INSERT INTO Followers(UserID, FollowingID) VALUES (7, 6);

INSERT INTO Comments(CommentID, CommentText, CommentDate, TwittID, UserID) VALUES (1, 'First comment','2018-09-17 23:03:45', 1, 5);
INSERT INTO Comments(CommentID, CommentText, CommentDate, TwittID, UserID) VALUES (2, 'Another comment', '2018-09-25 08:25:17', 2, 1);