//src/app/cart.service.ts

import { EventEmitter, Injectable, OnInit } from '@angular/core';
import { MenuItem, order } from './models';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CartService{

  constructor(private http: HttpClient) { }

  private cartItems: MenuItem[] = [];

  cartData = new EventEmitter<MenuItem[] | []>();


  addToCart(item: MenuItem): void {
    const existingItem = this.cartItems.find(cartItem => cartItem.id === item.id);
    if (existingItem) {
      existingItem.quantity++;
    } else {
      this.cartItems.push({ ...item, quantity: 1 });
    }
  }

  getCartItems(): MenuItem[] {
    return this.cartItems;
  }

  clearCart(): void {
    this.cartItems = [];
  }
  
  calculateTotalPrice(): number {
    let totalPrice = 0;
    for (const item of this.cartItems) {
      totalPrice += item.price * item.quantity;
    }
    return totalPrice;
  }

  removeFromCart(item: MenuItem): void {
    const index = this.cartItems.findIndex(i => i.id === item.id);
    if (index !== -1) {
      this.cartItems.splice(index, 1);
    }
  }

  // ********************************
  orderNow(data: order) {
    return this.http.post('http://localhost:3000/orders', data);
  }
  orderList() {
    let userStore = localStorage.getItem('user');
    let userData = userStore && JSON.parse(userStore);
    return this.http.get<order[]>('http://localhost:3000/orders?userId=' + userData.id);
  }

  // deleteCartItems(cartId: number) {
  //   return this.http.delete('http://localhost:3000/cart/' + cartId).subscribe((result) => {
  //     this.cartData.emit([]);
  //   })
  // }

  cancelOrder(orderId:number){
    return this.http.delete('http://localhost:3000/orders/'+orderId)

    // return this.removeFromCart();


  }
  // ***********************************************
}
  // *****************************************************************Chat gpt

//   private cartItems: CartItem[] = [];
//   addToCart(item: CartItem): void {
//     const existingCartItems: CartItem[] = JSON.parse(localStorage.getItem('cartItems') || '[]');
//     const updatedCartItems = [...existingCartItems, item];

//     localStorage.setItem('cartItems', JSON.stringify(updatedCartItems));
//   }

//   removeFromCart(item: CartItem): void {
//     const existingCartItems: CartItem[] = JSON.parse(localStorage.getItem('cartItems') || '[]');
//     const updatedCartItems = existingCartItems.filter(cartItem => cartItem.id !== item.id);

//     localStorage.setItem('cartItems', JSON.stringify(updatedCartItems));
//   }

//   getCartItems(): CartItem[] {
//     return JSON.parse(localStorage.getItem('cartItems') || '[]');
//   }

//   clearCart(): void {
//     localStorage.removeItem('cartItems');
//   }
//   calculateTotalPrice(): number {
//     let totalPrice = 0;
//     for (const item of this.cartItems) {
//       totalPrice += item.price * item.quantity;
//     }
//     return totalPrice;
//   }
// }











