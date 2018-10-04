\c sqltasks2

SELECT Users.UserName, '0' AS count
FROM Users
WHERE Users.UserID NOT IN (SELECT Followers.FollowingID FROM Followers)
UNION
SELECT Users.UserName, count(Followers.FollowingID) 
FROM Followers
INNER JOIN Users ON Followers.FollowingID = Users.UserID
GROUP BY Users.UserName;