package com.example.bookstore.model;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public class Book {

	public String Book(@RequestParam(value="title")String title, String author, Integer isbn, Integer year, Integer price, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("author", author);
		model.addAttribute("isbn", isbn);
		model.addAttribute("price", price);
		model.addAttribute("year", year);
		
		return "index";
	}
	
	
}
