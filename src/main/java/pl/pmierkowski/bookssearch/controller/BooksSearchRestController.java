package pl.pmierkowski.bookssearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.pmierkowski.bookssearch.model.BookOfferList;
import pl.pmierkowski.bookssearch.model.google.Item;
import pl.pmierkowski.bookssearch.model.google.VolumeInfo;
import pl.pmierkowski.bookssearch.service.BooksSearchService;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Validated
public class BooksSearchRestController {

    private static final String ISBN_REGEX = "^\\d{13}$";

    private BooksSearchService booksSearchService;

    @Autowired
    public BooksSearchRestController(BooksSearchService booksSearchService) {
        this.booksSearchService = booksSearchService;
    }

    @RequestMapping(value = "books/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<VolumeInfo> books(
            @Valid @Size(min = 3, max = 100)
            @RequestParam("title") String title
    ) {
        return this.booksSearchService.getByTitle(title)
                .getItems()
                .stream()
                .map(Item::getVolumeInfo)
                .filter(volumeInfo -> !Objects.isNull(volumeInfo.getIndustryIdentifiers()))
                .filter(
                        x -> x.getIndustryIdentifiers()
                                .stream()
                                .anyMatch(y -> y.getType().equals(BooksSearchService.REQUIRED_GOOGLE_TYPE))
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "offers/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public BookOfferList offers(
            @Valid @Pattern(regexp = ISBN_REGEX, message = "Invalid isbn, it must have 13 digits, for example: 9780596003999")
            @RequestParam("isbn") String isbn
    ) {
        return this.booksSearchService.getOffersByIsbn(isbn);
    }
}
