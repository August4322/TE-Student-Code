package com.techelevator.services;

import com.techelevator.model.SearchResults;
import org.springframework.web.client.RestTemplate;

public class IMDBService {

    private RestTemplate restTemplate = new RestTemplate();

    //Methods
    public SearchResults searchMovies(String searchTerm) {
        String url = "https://imdb-api.com/en/API/SearchMovie/k_sroq57j4/" + searchTerm;
        SearchResults results = restTemplate.getForObject(url, SearchResults.class);
        return results;
    }
}
