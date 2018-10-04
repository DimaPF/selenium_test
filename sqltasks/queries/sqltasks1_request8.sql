\c sqltasks1

SELECT Authors.Name, count(posts.PostID)
FROM Authors
INNER JOIN posts ON Authors.AuthorID = posts.AuthorID
GROUP BY Authors.AuthorID
ORDER BY count(posts.PostID) DESC LIMIT 5;