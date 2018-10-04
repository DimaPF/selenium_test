\c sqltasks2

SELECT Users.UserName, count(Followers.FollowingID) 
FROM Followers
INNER JOIN Users ON Followers.FollowingID = Users.UserID
GROUP BY Users.UserName;