import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartService } from '../cart.service';

import { RESTAURANTS } from '../dummy-data';
import { MenuItem, Restaurant } from '../models';
//import { MenuitemService } from '../services/menuitem.service';


@Component({
  selector: 'app-restaurant-menu',
  templateUrl: './restaurant-menu.component.html',
  styleUrls: ['./restaurant-menu.component.css']
})
export class RestaurantMenuComponent implements OnInit {

  restaurant: Restaurant | undefined;
  menuItemData: undefined | MenuItem;
  menuItemQuantity: number = 1;
  quantity: number=1;

  constructor(private route: ActivatedRoute, private cartService: CartService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const restaurantId = Number(params.get('id'));
      this.restaurant = RESTAURANTS.find(r => r.id === restaurantId);
    });
  }
  addToCart(item: MenuItem): void {
      this.cartService.addToCart(item);
      item.quantity++;
  }

  increaseQuantity(item: MenuItem): void {
    item.quantity++;
  }

  decreaseQuantity(item: MenuItem): void {
    if (item.quantity > 0) {
      item.quantity--;
    }
  }

  // handleQuantity(val:string){
  //   if (this.menuItemQuantity<20 && val ==='plus'){
  //     this.menuItemQuantity+=1;
  //   }
  //   else if(this.menuItemQuantity>1 && val=='min'){
  //     this.menuItemQuantity-=1;
  //   }
  // }

  // addToCart(){
  //   if(this.menuItemData){
  //     this.menuItemData.quantity = this.menuItemQuantity;
  //     // below function is when the user is not logged in
  //     if(!localStorage.getItem('user')){
  //         console.warn(this.menuItemData);
  //         this.menuitemservice.localAddToCart(this.menuItemData);
  //     }else{
  //         console.warn('else');
  //     }
  //   }
  // }
}
