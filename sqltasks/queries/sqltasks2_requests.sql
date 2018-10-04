\c sqltasks2

SELECT * 
FROM Twitts
ORDER BY Twitts.TwittDate DESC LIMIT 5;

SELECT avg(UserAge) 
FROM Users;

SELECT Users.UserName, '0' AS count
FROM Users
WHERE Users.UserID NOT IN (SELECT Followers.FollowingID FROM Followers)
UNION
SELECT Users.UserName, count(Followers.FollowingID) 
FROM Followers
INNER JOIN Users ON Followers.FollowingID = Users.UserID
GROUP BY Users.UserName;

SELECT Users.UserName, count(Followers.FollowingID) 
FROM Followers
INNER JOIN Users ON Followers.FollowingID = Users.UserID
GROUP BY Users.UserName;

SELECT Users.UserName
FROM Users
WHERE Users.UserID NOT IN (SELECT Twitts.UserID FROM Twitts);

SELECT Twitts.TwittID, '0' AS count
FROM Twitts
WHERE Twitts.TwittID NOT IN (SELECT Comments.TwittID FROM Comments)
UNION
SELECT Twitts.TwittID, count(Comments.CommentID) 
FROM Comments
INNER JOIN Twitts ON Comments.CommentID = Twitts.TwittID
GROUP BY Twitts.TwittID;

SELECT Twitts.UserID, Twitts.Text, TwittDate
FROM Twitts
INNER JOIN Users ON Users.UserID = Twitts.UserID
INNER JOIN Followers ON Followers.UserID = Users.UserID
WHERE Followers.FollowingID = 6
GROUP BY Twitts.UserID, Twitts.Text, TwittDate
UNION
SELECT Twitts.UserID, Twitts.Text, TwittDate
FROM Twitts
WHERE Twitts.UserID = 6
ORDER BY TwittDate DESC;

SELECT * 
FROM Comments
WHERE Comments.CommentDate >= ((NOW() AT TIME ZONE 'Europe/Kiev') - interval '10 hours');