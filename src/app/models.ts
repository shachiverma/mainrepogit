// src/app/models.ts

export interface Restaurant {
    id: number;
    name: string;
    cuisine: string;
    menu: MenuItem[];
    imageUrl: string;
    description: string;
    rating: number;
    address: string;
    phone: number;
    deliverytime: string;
  }
  
  export interface MenuItem {
    id: number;
    name: string;
    price: number;
    imageUrl: string; 
    quantity: number;
    //menuItemId: undefined | number;
  }

  export interface CartItem {
    id: number;
    name: string;
    price: number;
    quantity: number;
    imageUrl: string;
  }

  export interface signUp{
    name:string;
    email:string;
    password:string;
  }
  export interface login{
    email:string;
    password:string;
  }
  export interface order{
    email:string;
    address:string;
    contact:string;
    totalPrice:number;
    userId:string;
    id:number|undefined

  }
  // export interface priceSummary{
  //   price:number,
  //   discount:number,
  //   tax:number,
  //   delivery:number,
  //   total:number
  // }
  
  
  
  