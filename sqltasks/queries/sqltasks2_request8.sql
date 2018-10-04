\c sqltasks2

SELECT * 
FROM Comments
WHERE Comments.CommentDate >= ((NOW() AT TIME ZONE 'Europe/Kiev') - interval '10 hours');