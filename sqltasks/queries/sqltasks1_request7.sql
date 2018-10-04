\c sqltasks1

SELECT Tags.TagName, count(posts.PostID)
FROM Tags
INNER JOIN Tag_for_post ON Tag_for_post.TagID = Tags.TagID
INNER JOIN posts ON Tag_for_post.PostID = posts.PostID
GROUP BY Tags.TagID;