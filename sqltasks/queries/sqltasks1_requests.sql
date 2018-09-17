\c sqltasks1

SELECT count(*) 
FROM posts;

SELECT * 
FROM posts
WHERE posts.PostDate >= NOW() - '1 day'::INTERVAL;

SELECT * 
FROM posts
ORDER BY posts.PostDate DESC LIMIT 5;

SELECT posts.Title, posts.Text, array_to_string(array_agg(Tags.TagName), ',') AS Tags
FROM posts
INNER JOIN Tag_for_post ON Tag_for_post.PostID = posts.PostID
INNER JOIN Tags ON Tag_for_post.TagID = Tags.TagID
GROUP BY posts.PostID;

SELECT posts.Title, posts.Text
FROM posts
INNER JOIN Tag_for_post ON Tag_for_post.PostID = posts.PostID
INNER JOIN Tags ON Tag_for_post.TagID = Tags.TagID
WHERE Tags.TagName = ''
GROUP BY posts.PostID;

SELECT posts.Title, posts.Text
FROM posts
WHERE posts.Title LIKE 'S%';

SELECT Tags.TagName, count(posts.PostID)
FROM Tags
INNER JOIN Tag_for_post ON Tag_for_post.TagID = Tags.TagID
INNER JOIN posts ON Tag_for_post.PostID = posts.PostID
GROUP BY Tags.TagID;

SELECT Authors.Name, count(posts.PostID)
FROM Authors
INNER JOIN posts ON Authors.AuthorID = posts.AuthorID
GROUP BY Authors.AuthorID
ORDER BY count(posts.PostID) DESC LIMIT 5;
