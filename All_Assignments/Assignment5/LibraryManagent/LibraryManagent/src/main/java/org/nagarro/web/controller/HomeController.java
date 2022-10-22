package org.nagarro.web.controller;

import java.util.List;

import org.nagarro.web.model.BookModel;
import org.nagarro.web.model.UserModel;
import org.nagarro.web.services.BookService;
import org.nagarro.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String home() {
		return "<h1>Home</h1>";
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserModel user) {
		if (userService.authenticate(user.getUsername(), user.getPassword())) {
			return ResponseEntity.ok(user);
		}
		else {
			return ResponseEntity.badRequest().body(false);
		}
    }
	
	@PostMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody BookModel book){
		bookService.updateBook(book);
		List<BookModel> bookList = bookService.getBookDetails();
		if(!bookList.isEmpty()) {
			return ResponseEntity.ok(bookList);
		}
		else {
			return ResponseEntity.badRequest().body(false);
		}
	}
}