-- 10. The names of directors who have directed a movie over 3 hours [180 minutes] (15 rows)
SELECT DISTINCT person.person_name
FROM movie
JOIN person ON movie.director_id = person.person_id
WHERE movie.length_minutes > 180;