# Canopy Technical Skills Interview - Android

Using [MovieDB trending API](https://developers.themoviedb.org/3/getting-started/introduction), you are to display the most popular movies in a list.

You are responsible for creating:

- A view of a list of movies with the title and the image using either Jetpack Compose or XML.
- A detail view showing the following (using Jetpack Compose or XML):
  1. Movie poster image 
  2. Movie title
  3. Movie overview
  4. Vote Average 
  5. A text box allowing the user to submit a rating of a range of 0.5 - 10.0 
  6. A submit rating buttion if the user has enter in a rating for the movie.

Feel free to add 3rd party libraries to the project. You can use any architecture practices you believe to be best to do this. As for the UI, please try to use Jetpack Compose, XML, or both if you'd like to try and impress us.
   
### Details for retrieving data
The MovieDB token is in the project marked with a ***TODO***. A simple search of `TODO` should locate it.

- Hit the [Get Popular](https://developers.themoviedb.org/3/movies/get-popular-movies) `GET /movie/popular` endpoint and consume the data.
- Then use info received to retrieve images [Fetch Images](https://developers.themoviedb.org/3/getting-started/images).
- Use the [Rate Move](https://developers.themoviedb.org/3/movies/rate-movie) endpoint to POST the rating for the movie. (In the past the DB backend has had issues with this endpoint. If you see 400 errors, the error may still exist.)

With those three endpoints you will have the needed data to display everything to the user and add a rating.

Feel free to create the UI you think is best for the rows.

### Bonus points
Implement a caching system

**This is NOT meant to take long. Don't worry about "perfection" with the UI**

### Final notes
***You have two days to complete this. Please send us a zip of your solution within that timeframe.***

Feel free to reach out if you have any questions! We look forward to seeing your solution!!!!
