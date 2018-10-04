\c sqltasks2

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