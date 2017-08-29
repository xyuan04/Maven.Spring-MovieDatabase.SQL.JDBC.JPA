# Persistence

## Part 1: SQL

The following lab is to be completed using the H2 Console. Once you have figured out the correct queries for each step, save a copy in a file called `src/main/resources/script.sql`. This will be how you submit this assignment. If at any time you need to reset the database, you can restart your Spring Boot server.

### Mini Movie Database

Add the following movies to the `movies` table using an insert statement:

| Title | Runtime | Genre | IMDB Score | Rating |
| ----- | ------- | ----- | ----------- | ----- |
| Howard the Duck | 110 | Sci-Fi | 4.6 | PG |
| Lavalantula | 83 | Horror | 4.7 | TV-14 |
| Starship Troopers | 129 | Sci-Fi | 7.2 | PG-13 |
| Waltz With Bashir | 90 | Documentary | 8.0 | R |
| Spaceballs | 96 | Comedy | 7.1 | PG |
| Monsters Inc. | 92 | Animation | 8.1 | G |

Add a few more movies of your choosing.

Create a query to find all movies in the Sci-Fi genre.

Create a query to find all films that scored at least a 6.5 on IMDB

For parents who have young kids, but who don't want to sit through long children's movies, create a query to find all of the movies rated G or PG that are less than 100 minutes long.

Create a query to show the average runtimes of movies rated below a 7.5, grouped by their respective genres.

There's been a data entry mistake; Starship Troopers is actually rated R, not PG-13. Create a query that finds the movie by its title and changes its rating to R.

Show the ID number and rating of all of the Horror and Documentary movies in the database. Do this in only one query.

This time let's find the average, maximum, and minimum IMDB score for movies of each rating.

That last query isn't very informative for ratings that only have 1 entry. use a `HAVING COUNT(*) > 1` clause to only show ratings with multiple movies showing.

Let's make our movie list more child-friendly. Delete all entries that have a rating of R. Remember to record your query in `script.sql`.

## Part 2: JDBC

### 2A: People

Create a `PersonService` class. These will be used to manipulate the contents of the database given program requirements. Remember to use a `JdbcTemplate` to provide access to your database. All database access logic and sorting/filtering should be handled by your `PersonService` and the SQL queries it issues to the database.

You can provide your `PersonService` to any controller that needs it by marking it as a `@Service` class and autowiring it into the appropriate controller. Remember that you will also need a corresponding `Person` class to hold the data in transit. You do not need to use any of the JPA annotations (`@ID`, `@Entity` etc.) in your Person class.

Support the following operations:

- Add a `Person` to the database
- Update an existing `Person` in the database
- Remove a person from the database
- remove a list of people from the database
- find all people with a particular first name, last name, or birthdate
- Find a single person by ID
- Generate a map of surnames to lists of people with that surname
- Generate a map of first names to the number of times they occur.

Create the following REST endpoints to interact with the application. You can use postman to confirm your program's behavior.

 - `POST` `/people` -- create a person
 - `PUT` `/people/{id}` -- update person with `id`. 404 error if that person doesn't exist yet
 - `GET` `/people/{id}` -- get the person with the specified ID
 - `DELETE` `/people/{id}` -- Delete the person with the specified ID
 - `GET` `/people` -- get all people in the database
 - `GET` `/people/reverselookup/{mobileNumber}` -- find all people with the specified mobile number
 - `GET` `/people/surname/{lastName}` -- Find all people with a particular last name
 - `GET` `/people/surname` -- Get the result of the surname report above
 - `GET` `/people/firstname/stats` -- Get the report of first name frequencies
 