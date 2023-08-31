import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';
import { CartItem, order } from '../models';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent {

  totalPrice: number | undefined;
  cartData: CartItem[] | undefined;
  orderMsg: string | undefined;
  constructor( private router: Router,private cartService: CartService) { }

  ngOnInit(): void {

  }
  getTotalAmount(): number {
    return this.cartService.calculateTotalPrice();
  }
  orderNow(data: { email: string, address: string, contact: string }) {
    let user = localStorage.getItem('user');
    let userId = user && JSON.parse(user).id;
    if (this.getTotalAmount()) {
      let orderData: order = {
        ...data,
        totalPrice: this.getTotalAmount(),
        userId,
        id: undefined
      }

      this.cartData?.forEach((item) => {
        setTimeout(() => {
          item.id && this.cartService.removeFromCart(item);
        }, 700)
      })

      this.cartService.orderNow(orderData).subscribe((result) => {
        if (result) {
          this.orderMsg = "Order has been placed";
          setTimeout(() => {
            this.orderMsg = undefined;
            this.router.navigate(['/my-orders'])
          }, 4000);

        }

      })
    }

  }
  
}


