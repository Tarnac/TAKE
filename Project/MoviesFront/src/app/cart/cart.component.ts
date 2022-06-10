import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { Movie } from '../movie';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart!: Movie[];
  totalPrice!: number;

  constructor(
    private cartService: CartService,
    private location: Location
    ) { }

  ngOnInit(): void {
    this.cart = this.cartService.getMovies();
    this.totalPrice = this.cartService.getTotalPrice();
  }

  removeMovieFromCart(movie: Movie){
    this.cartService.removeMovieFromCart(movie);
    this.cart = this.cartService.getMovies();
    this.totalPrice = this.cartService.getTotalPrice();
  }

  clear(){
    this.cartService.clear();
    this.cart = this.cartService.getMovies();
    this.totalPrice = this.cartService.getTotalPrice();
  }

  goBack(): void {
    this.location.back();
  }

}
