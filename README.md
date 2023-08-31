# ResApp - Food Delivery App

ResApp is a food delivery application that allows users to browse various restaurants, explore menus, and place food orders. It provides features for user authentication, restaurant selection, menu browsing, and order management.

## Features

- User Authentication: Users can sign up and log in to the app to access its features.
- Restaurant Selection: Browse through a list of restaurants available on the platform.
- Menu Exploration: View the menus of selected restaurants, including available food items and prices.
- Cart Management: Add items to the cart while exploring menus.
- Order Checkout: Proceed to checkout, review the order, and place it.
- Order History: Users can view their past order history.
- Logout: Users can log out from their accounts.

## Components

The app is structured into the following components:

- `cart`: Manages the items added by the user to their cart.
- `checkout`: Handles the order checkout process.
- `header`: Displays the app header with navigation and user information.
- `my-orders`: Displays the user's order history.
- `restaurant-list`: Lists available restaurants for users to choose from.
- `restaurant-menu`: Displays the menu of a selected restaurant.
- `user-auth`: Manages user authentication and account-related actions.
- `services`: Contains services for API communication and data management.

## Getting Started

1. Clone the repository: `git clone https://github.com/yourusername/ResApp.git`
2. Navigate to the project directory: `cd ResApp`
3. Install dependencies: `npm install bootstrap`
4. Start the JSON server for simulating API calls: `json-server --watch db.json`
5. Start the development server: `ng serve -o`

## Technologies Used

- Angular: Frontend user interface development.
- JSON Server: Simulating a backend server for API calls and data management.

## Screenshots
![Restaurant List](assets/screenshots/Screenshot(17).png)

![Login/SignUp](assets/screenshots/Screenshot(16).png)
![Login/SignUp](assets/screenshots/Screenshot(15).png)
![Login/SignUp](assets/screenshots/Screenshot(14).png)

![Cart](assets/screenshots/Screenshot(18).png)

![Checkout](assets/screenshots/Screenshot(24).png)
![Checkout](assets/screenshots/Screenshot(20).png)

![Order History](assets/screenshots/Screenshot(23).png)



