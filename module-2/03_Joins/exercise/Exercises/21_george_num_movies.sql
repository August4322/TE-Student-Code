-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'
SELECT person.person_name, COUNT(movie.movie_id) AS num_of_movies
FROM person
LEFT JOIN movie_actor ON person.person_id = movie_actor.actor_id
LEFT JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE person_name LIKE 'George %'
GROUP BY person.person_id
ORDER BY person.person_name ASC;