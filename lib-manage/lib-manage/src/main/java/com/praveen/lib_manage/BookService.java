package com.praveen.lib_manage;

import com.praveen.lib_manage.Book;
import com.praveen.lib_manage.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }

    public List<Book> search(String title, String author, String category) {
        if (title != null) return bookRepo.findByTitleContainingIgnoreCase(title);
        if (author != null) return bookRepo.findByAuthorContainingIgnoreCase(author);
        return bookRepo.findByCategoryContainingIgnoreCase(category);
    }
}
