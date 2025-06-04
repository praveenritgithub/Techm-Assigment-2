package com.praveen.lib_manage;

import com.praveen.lib_manage.Book;
import com.praveen.lib_manage.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookRepo.findAll();
        model.addAttribute("books", books);
        return "users/books/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "users/books/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookRepo.save(book);
        return "redirect:/books";
    }
}
