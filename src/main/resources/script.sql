SELECT * FROM movie WHERE genre = 'Sci-Fi';

SELECT * FROM movie WHERE imdb_score > 6.5;

SELECT * FROM movie WHERE (rating = 'G' OR rating = 'PG') AND runtime < 100;

SELECT genre, AVG(runtime) FROM movie WHERE rating < 7.5 GROUP BY genre;

UPDATE movie SET rating = 'R' WHERE title = 'Starship Troopers';

SELECT id, rating FROM movie WHERE genre = 'Horror' OR genre = 'Documentary';

SELECT rating, AVG(imdb_score), MIN(imdb_score), MAX(imdb_score) from movie GROUP BY rating;

SELECT rating, AVG(imdb_score), MIN(imdb_score), MAX(imdb_score) from movie GROUP BY rating HAVING COUNT(*) > 1;

DELETE FROM movie where rating = 'R';

