package pl.pmierkowski.bookssearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pmierkowski.bookssearch.model.google.GoogleBooks;
import pl.pmierkowski.bookssearch.service.BooksSearchService;
import org.springframework.http.MediaType;

@RestController
public class BooksSearchRestController {

    private BooksSearchService booksSearchService;

    @Autowired
    public BooksSearchRestController(BooksSearchService booksSearchService) {
        this.booksSearchService = booksSearchService;
    }

    @RequestMapping(value = "search-books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GoogleBooks searchBooks(@RequestParam String title) {
        return this.booksSearchService.searchBooks(title);
    }
}
