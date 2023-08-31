import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
 import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { MyOrdersComponent } from './my-orders/my-orders.component';

import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { RestaurantMenuComponent } from './restaurant-menu/restaurant-menu.component';
import { UserAuthComponent } from './user-auth/user-auth.component';



const routes: Routes = [
  { path: 'cart', component: CartComponent }, 
  { path:'user-auth',component:UserAuthComponent},
  { path: 'checkout', component: CheckoutComponent },
  { path: '', redirectTo: '/restaurants', pathMatch: 'full' },
  { path: 'restaurants', component: RestaurantListComponent },
  { path: 'menu/:id', component: RestaurantMenuComponent },
  {
    component:MyOrdersComponent,
    path:'my-orders'
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
