\c sqltasks1

SELECT posts.Title, posts.Text, array_to_string(array_agg(Tags.TagName), ',') AS Tags
FROM posts
INNER JOIN Tag_for_post ON Tag_for_post.PostID = posts.PostID
INNER JOIN Tags ON Tag_for_post.TagID = Tags.TagID
GROUP BY posts.PostID;