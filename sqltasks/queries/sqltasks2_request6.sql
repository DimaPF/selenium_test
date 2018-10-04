\c sqltasks2

SELECT Twitts.TwittID, '0' AS count
FROM Twitts
WHERE Twitts.TwittID NOT IN (SELECT Comments.TwittID FROM Comments)
UNION
SELECT Twitts.TwittID, count(Comments.CommentID) 
FROM Comments
INNER JOIN Twitts ON Comments.CommentID = Twitts.TwittID
GROUP BY Twitts.TwittID;