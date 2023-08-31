// src/app/app.component.ts
import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Restaurant } from './models';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isHomePage: boolean = false; // Provide an initial value here
  searchResults: Restaurant[] = []; // Provide an initial value here

  constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.isHomePage = event.url === '/';
        console.log('Is home page:', this.isHomePage);
      }
    });
  }
  
  
}
  
  
  
  


