package pl.pmierkowski.bookssearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pmierkowski.bookssearch.model.BookOfferList;
import pl.pmierkowski.bookssearch.model.google.Item;
import pl.pmierkowski.bookssearch.model.google.VolumeInfo;
import pl.pmierkowski.bookssearch.service.BooksSearchService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BooksSearchRestController {

    private BooksSearchService booksSearchService;

    @Autowired
    public BooksSearchRestController(BooksSearchService booksSearchService) {
        this.booksSearchService = booksSearchService;
    }

    @RequestMapping(value = "books/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VolumeInfo> searchBooks(@RequestParam("title") String title) {
        return this.booksSearchService.getByTitle(title)
                .getItems()
                .stream()
                .map(Item::getVolumeInfo)
                .filter(
                        x -> x.getIndustryIdentifiers()
                                .stream()
                                .anyMatch(y -> y.getType().equals(BooksSearchService.REQUIRED_GOOGLE_TYPE))
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "offers/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BookOfferList getOffersByIsbn(@RequestParam("isbn") String isbn) {
        return this.booksSearchService.getOffersByIsbn(isbn);
    }
}
