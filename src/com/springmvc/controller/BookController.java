package com.springmvc.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.entity.Book;
import com.springmvc.entity.Category;
import com.springmvc.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("/list")
	public String listBooks(ModelMap theModel) {
		theModel.addAttribute("listBooks", bookService.getBooks());
		return "book-list";
	}
	
	
	@GetMapping("/addBook")
	public String addBook(ModelMap theModel) {
		Book theBook = new Book();
		theModel.addAttribute("theBook", theBook);
		getDependencyForBook(theModel);
		return "book-form";
		
	}
	
	@PostMapping("/saveBook")
	public String saveCustomer(@ModelAttribute("theBook") Book theBook) {
		
		// save the customer using our service
		bookService.saveBook(theBook);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("bookId") Integer bookId , ModelMap theModel) {
		
		Book theBook = bookService.getBook(bookId);
		theModel.addAttribute("theBook", theBook);
		getDependencyForBook(theModel);
		
		return "book-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") Integer bookId) {
		bookService.deleteBook(bookId);
		return "redirect:/book/list";
	}
	
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName , ModelMap theModel) {
		
		List <Book> listBooks = bookService.searchBooks(theSearchName);
		
        theModel.addAttribute("listBooks", listBooks);
        
        return "book-list"; 
		
	}
	
	// ================== SUPPORT
	public void getDependencyForBook(ModelMap theModel) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Category> categorys = session.createQuery("FROM Category ORDER BY name").list();
		theModel.addAttribute("categorys", categorys);
	}

}
