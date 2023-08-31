import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RestaurantListComponent } from './restaurant-list/restaurant-list.component';
import { RestaurantMenuComponent } from './restaurant-menu/restaurant-menu.component';
import { HeaderComponent } from './header/header.component';
 import { CartComponent } from './cart/cart.component';

import { CheckoutComponent } from './checkout/checkout.component';
import { RouterModule } from '@angular/router';
import { UserAuthComponent } from './user-auth/user-auth.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MyOrdersComponent } from './my-orders/my-orders.component';


@NgModule({
  declarations: [
    AppComponent,
    RestaurantListComponent,
    RestaurantMenuComponent,
    HeaderComponent,
    CartComponent,
    CheckoutComponent,
    UserAuthComponent,
    MyOrdersComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
