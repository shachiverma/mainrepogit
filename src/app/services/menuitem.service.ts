// import { EventEmitter, Injectable } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
// import { MenuItem } from '../models';

// @Injectable({
//   providedIn: 'root'
// })
// export class MenuitemService {

//   cartData = new EventEmitter<MenuItem[] | []>();

//   constructor(private http: HttpClient) { }

//   localAddToCart(data: MenuItem) {
//     let cartData = [];
//     let localCart = localStorage.getItem('localCart');
//     if (!localCart) {
//       localStorage.setItem('localCart', JSON.stringify([data]));
//       this.cartData.emit([data]);
//     } else {
//       cartData = JSON.parse(localCart);
//       cartData.push(data);
//       localStorage.setItem('localCart', JSON.stringify(cartData));
//       this.cartData.emit(cartData);
//     }
//   }
// }
