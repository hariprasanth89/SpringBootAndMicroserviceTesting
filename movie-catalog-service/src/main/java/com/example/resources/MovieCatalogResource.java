package com.example.resources;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.CatalogItem;
import com.example.model.Movie;
import com.example.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	 @Autowired
	    private RestTemplate restTemplate;

	   // @Autowired
	   // WebClient.Builder webClientBuilder;
	   
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		//System.out.println("${welcome}");
		//eturn Collections.singletonList(new CatalogItem("Test est","TEST",4));
		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
                }).collect(Collectors.toList());
		
	}

}
