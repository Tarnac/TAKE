package lab.movies.controllers;

import lab.movies.models.Movie;
import lab.movies.repositories.MovieRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable Long id){
        return movieRepository.findById(id).orElse(null);
    }
}
