package pl.pmierkowski.bookssearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BooksSearchController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
