import { Injectable } from '@angular/core';

import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private cart: Movie[];
  private totalPrice: number;

  constructor() {
    this.cart = [];
    this.totalPrice = 0.0;
   }


  getMovies(): Movie[]{
    return this.cart;
  }

  getTotalPrice(): number{
    return this.totalPrice;
  }

  addMovieToCart(movie: Movie) {
    this.cart.push(movie)
    this.totalPrice += movie.price;
  }

  removeMovieFromCart(movieToRemove: Movie){
    this.cart = this.cart.filter(movie => movie.id != movieToRemove.id)
    this.totalPrice -= movieToRemove.price;
  }

  isMovieInCart(movie: Movie) {
    return this.cart.filter((movieInCart) => movieInCart.id === movie.id).length > 0
  }

  clear(){
    this.cart = [];
    this.totalPrice = 0.0;
  }


}
