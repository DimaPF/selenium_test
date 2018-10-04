\c sqltasks1

SELECT * 
FROM posts
WHERE posts.PostDate >= NOW() - '1 day'::INTERVAL;