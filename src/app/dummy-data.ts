// src/app/dummy-data.ts

import { Restaurant } from './models';

export const RESTAURANTS: Restaurant[] = [
  {
    id: 1,
    name: 'McDonalds',
    cuisine: 'Fastfood',
    imageUrl: '/assets/images/food00.jpg',
    description: "The world's most famous fast-food restaurant, which sells hamburgers, cooked chicken pieces, French fries, salads, and other types of fast food.",
    rating: 4.5,
    address:'USA',
    phone:9559786378,
    deliverytime:'12pm-12am',
    menu: [
      { id: 1, name: 'Veg Burger', price: 10, imageUrl:'/assets/images/mcveggie.jpg',quantity:0},
      { id: 2, name: 'McAlooTikki Burger', price: 10, imageUrl:'/assets/images/mcaloo.jpg',quantity: 0},
      { id: 3, name: 'Chicken Burger', price: 10, imageUrl:'/assets/images/mcChicken-burger-1.jpg',quantity: 0},
      { id: 4, name: 'ButterChicken Burger', price: 10, imageUrl:'/assets/images/butterchicken.jpg',quantity: 0},
      { id: 5, name: 'Fries', price: 10, imageUrl:'/assets/images/all-3-fries.jpg',quantity: 0},
      { id: 6, name: 'MacPuff', price: 10, imageUrl:'/assets/images/macpuff.jpg',quantity: 0},
      
    ],
  },
  {
    id: 2,
    name: 'Sushi World',
    cuisine: 'Japanese',
    imageUrl: '/assets/images/food11.jpg',
    description: 'Experience the flavors of Japan with our diverse menu at Sushi-World.',
    rating: 4.0,
    address:'USA',
    phone:9559786378,
    deliverytime:'12pm-12am',
    menu: [
      
      { id: 7, name: 'Sushi', price: 3,imageUrl:'/assets/images/sushi.jpg',quantity: 0},
      { id: 8, name: 'Spicy Ramen', price: 10, imageUrl:'/assets/images/spicyramen.jpg',quantity: 0},
      
    ],
  },
  {
    id: 3,
    name: 'Paradise',
    cuisine: 'USA',
    imageUrl: '/assets/images/food77.jpg',
    description: 'Experience the flavors of USA with our diverse menu at Paradise.',
    rating: 4.0,
    address:'USA',
    phone:9559786378,
    deliverytime:'12pm-12am',
    menu: [
      
      { id: 9, name: 'Crossaint', price: 3,imageUrl:'/assets/images/food77.jpg',quantity: 0 },
      { id: 10, name: 'Pastries', price: 10, imageUrl:'/assets/images/food22.jpg',quantity: 0},
      
    ],
  },
  {
    id: 4,
    name: 'Rock N Rolls',
    cuisine: 'Indian',
    imageUrl: '/assets/images/food33.jpg',
    description: 'Experience the flavors of India with our diverse menu at RockNRolls.',
    rating: 4.0,
    address:'USA',
    phone:9559786378,
    deliverytime:'12pm-12am',
    menu: [
      
      { id: 11, name: 'Crossaint', price: 3,imageUrl:'/assets/images/food77.jpg',quantity: 0},
      { id: 12, name: 'Pastries', price: 10, imageUrl:'/assets/images/food22.jpg',quantity: 0},
      
    ],
  },
  {
    id: 5,
    name: 'China Town',
    cuisine: 'Chineese',
    imageUrl: '/assets/images/food55.jpg',
    description: 'Experience the flavors of China with our diverse menu at China-Town.',
    rating: 4.0,
    address:'USA',
    phone:9559786378,
    deliverytime:'12pm-12am',
    menu: [
      
      { id: 13, name: 'Crossaint', price: 3,imageUrl:'/assets/images/food77.jpg',quantity: 0 },
      { id: 14, name: 'Pastries', price: 10, imageUrl:'/assets/images/food22.jpg',quantity: 0},
      
    ],
  },
  {
    id: 6,
    name: 'Sagar Ratna',
    cuisine: 'Indian-Continental',
    imageUrl: '/assets/images/paneer.jpg',
    description: 'Experience the flavors of India with our diverse menu at Sagar Ratna.',
    rating: 4.0,
    address:'USA',
    phone:9559786378,
    deliverytime:'12pm-12am',
    menu: [
      
      { id: 15, name: 'Crossaint', price: 300,imageUrl:'/assets/images/food77.jpg',quantity: 0},
      { id: 16, name: 'Pastries', price: 85, imageUrl:'/assets/images/food22.jpg',quantity: 0},
      
    ],
  },
  
];
