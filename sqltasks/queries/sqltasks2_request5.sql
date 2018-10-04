\c sqltasks2

SELECT Users.UserName
FROM Users
WHERE Users.UserID NOT IN (SELECT Twitts.UserID FROM Twitts);