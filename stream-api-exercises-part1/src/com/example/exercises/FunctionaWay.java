package com.example.exercises;

import java.util.Collection;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

public class FunctionaWay {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
		final Collection<Movie> movies = movieService.findAllMovies();
		long count = movies.stream().parallel().filter(FunctionaWay::is70s).count();
//        		.mapToLong( movie -> 1)
//        		.reduce( 0L , (s,i)->s+i);
		System.out.println(count);
	}

	static boolean is70s(Movie movie) {
		return movie.getYear() >= 1970 && movie.getYear() < 1980;
	}
}
