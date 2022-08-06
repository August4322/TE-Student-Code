package com.techelevator.controller;

import com.techelevator.model.Movie;
import com.techelevator.model.SearchResults;
import com.techelevator.services.IMDBService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MovieController {

    //Not Best Practice, just for time (should use dependency injection)
    private IMDBService imdb = new IMDBService();

    @RequestMapping( path = "/hello", method = RequestMethod.GET)
    public String sayHelloWorld() {
        return "Hello World";
    }

    @RequestMapping( path = "/searchMovie/{searchTerm}", method = RequestMethod.GET)
    public List<Movie> searchMovies(@PathVariable String searchTerm) {
        SearchResults results = imdb.searchMovies(searchTerm);
        return results.getMovies();
    }

}
