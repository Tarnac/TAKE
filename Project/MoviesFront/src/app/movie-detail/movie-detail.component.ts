import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { CartService } from '../cart.service';



@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  movie?: Movie;

  constructor(
    private route:ActivatedRoute,
    private movieService: MovieService,
    private location: Location,
    private cartService: CartService
  ) { }

  ngOnInit(): void {
    this.getMovie();
  }

  getMovie(): void {
    const pathId = this.route.snapshot.paramMap.get('id');
    if (pathId) {
      this.movieService.getMovie(+pathId)
        .subscribe(movie => this.movie = movie);
    }
  }

  goBack(): void {
    this.location.back();
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
