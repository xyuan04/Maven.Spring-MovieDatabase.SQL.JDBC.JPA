create table movie
(
    id int auto_increment,
    title varchar(50) null,
    runtime int null,
    genre varchar(50) null,
    imdb_score decimal(4,1) null,
    rating varchar(50) null,
    constraint movie_pk
        primary key (id)
);

INSERT INTO movies.movie (title, runtime, genre, imdb_score, rating)
VALUES ('Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');

INSERT INTO movies.movie (title, runtime, genre, imdb_score, rating)
VALUES ('Lavalantula', 83, 'Horror', 4.7, 'TV-14');

INSERT INTO movies.movie (title, runtime, genre, imdb_score, rating)
VALUES ('Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');

INSERT INTO movies.movie (title, runtime, genre, imdb_score, rating)
VALUES ('Waltz with Bashir', 90, 'Documentary', 8.0, 'R');

INSERT INTO movies.movie (title, runtime, genre, imdb_score, rating)
VALUES ('Spaceballs', 96, 'Comendy', 7.1, 'PG');

INSERT INTO movies.movie (title, runtime, genre, imdb_score, rating)
VALUES ('Monsters Inc.', 92, 'Animation', 8.1, 'G');

