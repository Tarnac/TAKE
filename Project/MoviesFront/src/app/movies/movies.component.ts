import { Component, OnInit } from '@angular/core';
import { Category } from '../category';

import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { CategoryService } from '../category.service';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {

  movies!: Movie[];
  categories!: Category[];

  constructor(
    private movieService: MovieService,
    private categoryService: CategoryService,
    private cartService: CartService
    ) { }

  ngOnInit(): void {
    this.getMovies();
    this.getCategories();
  }

  getMovies(): void{
    this.movieService.getMovies().subscribe(movies => this.movies = movies);
  }

  getMoviesByCategory(event: Event): void{
    this.movieService.getMovies().subscribe(movies => {
      this.movies = movies;
      // @ts-ignore
      if (event.target.value != "ALL"){
        // @ts-ignore
        this.movies = this.movies.filter(movie => movie.category.name === event.target.value)
      }
    });
  }

  getCategories(): void{
    this.categoryService.getCategories().subscribe(categories => this.categories = categories);
  }

  isMovieInCart(movie: Movie){
    return this.cartService.isMovieInCart(movie);
  }

  removeMovieFromCart(movie: Movie){
    this.cartService.removeMovieFromCart(movie);
  }

  addMovieToCart(movie: Movie){
    this.cartService.addMovieToCart(movie);
  }

}
