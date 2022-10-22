package org.nagarro.web.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nagarro.web.constants.Constant;
import org.nagarro.web.model.BookModel;
import org.nagarro.web.model.UserModel;
import org.nagarro.web.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String home() {
		return Constant.homeView;
	}
	@GetMapping("/addbook")
	public String addBook() {
		return Constant.addBook;
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(Constant.currUser, null);
		return Constant.homeView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(UserModel user, HttpServletRequest request) throws URISyntaxException {
		ModelAndView mv = new ModelAndView();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		URI uri = new URI("http://localhost:8181/login");
		UserModel userData = new UserModel();

		userData.setUsername(user.getUsername());
		userData.setPassword(user.getPassword());

		HttpEntity<UserModel> httpEntity = new HttpEntity<>(userData, headers);

		RestTemplate restTemplate = new RestTemplate();
		UserModel userModel = restTemplate.postForObject(uri, httpEntity, UserModel.class);
		System.out.println(userModel.toString());
		
		if(Objects.nonNull(userModel)) {
			
			HttpSession session = request.getSession();
			List<BookModel> bookList = bookService.getBookDetails();
			mv.addObject(Constant.bookList, bookList);
			session.setAttribute(Constant.currUser, user.getUsername());
			mv.setViewName(Constant.bookListing);
			return mv;
		}
		else {
			mv.setViewName(Constant.homeView);
			return mv;
		}
	}
	
	
	@GetMapping("/editview/{id}")
	public ModelAndView editBookDetails(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		BookModel book = bookService.getBookById(id);
		mv.addObject(Constant.bookObj, book);
		mv.setViewName(Constant.editBook);
		return mv;
		
	}
	
	@PostMapping("/update")
	public ModelAndView update(BookModel book) {
		ModelAndView mv = new ModelAndView();
		bookService.updateBook(book);
		List<BookModel> bookList = bookService.getBookDetails();
		mv.addObject(Constant.bookList, bookList);
		mv.setViewName(Constant.bookListing);
		return mv;
	}
	
	
	@PostMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		ModelAndView mv = new ModelAndView();
		bookService.deleteBookById(id);
		List<BookModel> bookList = bookService.getBookDetails();
		mv.addObject(Constant.bookList, bookList);
		mv.setViewName(Constant.bookListing);
		return mv;
	}
	
	@PostMapping("/insert")
	public ModelAndView addBookDetails(@Validated BookModel book) {
		ModelAndView mv = new ModelAndView();
		bookService.insertBookDetail(book);
		System.out.println(book.toString());
		List<BookModel> bookList = bookService.getBookDetails();
		mv.addObject(Constant.bookList, bookList);
		mv.setViewName(Constant.bookListing);
		return mv;
	}
}
