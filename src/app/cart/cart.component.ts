import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { CartItem, MenuItem } from '../models'; // Import the CartItem type

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  cartItems: CartItem[] = [];
  
  constructor(private cartService: CartService, private router: Router) {
    this.cartItems = this.cartService.getCartItems();
  }
  ngOnInit(): void {
   
  }

  decreaseQuantity(item: CartItem): void {
    if (item.quantity > 1) { 
      item.quantity--;
    }
  }

  increaseQuantity(item: CartItem): void {
    item.quantity++;
  }

  checkout(): void {
    this.router.navigate(['/checkout']);
  }

  getTotalPrice(): number {
    return this.cartService.calculateTotalPrice(); 
  }

  removeItem(item: CartItem): void {
    this.cartService.removeFromCart(item);
  }
  
}
