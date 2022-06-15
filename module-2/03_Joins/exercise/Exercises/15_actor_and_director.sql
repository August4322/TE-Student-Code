-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT movie.title, person.person_name
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE movie_actor.actor_id = movie.director_id;