import { Component } from '@angular/core';
import { CartService } from '../cart.service';
import { order } from '../models';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.css']
})
export class MyOrdersComponent {

  // params: string = '';

  orderData:order[]|undefined
  constructor(private cartService:CartService) { }

  ngOnInit(): void {
    this.getOrderList()
  }
  cancelOrder(orderId:number|undefined){
    orderId && this.cartService.cancelOrder(orderId).subscribe((result)=>{
      if(result){
        this.getOrderList();
      }
    })
  }
  getOrderList(){
    this.cartService.orderList().subscribe((result)=>{
      this.orderData=result;
    })
  }

}
