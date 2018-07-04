package pl.pmierkowski.bookssearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.pmierkowski.bookssearch.repository.GoogleBooksRestRepository;

@Controller
public class BooksSearchController {

    private GoogleBooksRestRepository googleBooksRestRepository;

    @Autowired
    public BooksSearchController(GoogleBooksRestRepository googleBooksRestRepository) {
        this.googleBooksRestRepository = googleBooksRestRepository;
    }

    @RequestMapping("/")
    public String index() {

        this.googleBooksRestRepository.searchBooks("Java books");

        return "index";
    }
}
