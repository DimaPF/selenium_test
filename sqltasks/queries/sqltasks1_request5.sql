\c sqltasks1

SELECT posts.Title, posts.Text
FROM posts
INNER JOIN Tag_for_post ON Tag_for_post.PostID = posts.PostID
INNER JOIN Tags ON Tag_for_post.TagID = Tags.TagID
WHERE Tags.TagName = ''
GROUP BY posts.PostID;