import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RESTAURANTS } from '../dummy-data';
import { Restaurant } from '../models';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {
  
  restaurants: Restaurant[] = RESTAURANTS;

  constructor(private router: Router) { }

ngOnInit() {
  
}
}






