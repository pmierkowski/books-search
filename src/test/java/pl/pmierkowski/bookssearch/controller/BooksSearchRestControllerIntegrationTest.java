package pl.pmierkowski.bookssearch.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BooksSearchRestController.class)
public class BooksSearchRestControllerIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void shouldReturnBooksListWhenGivenValidQuery() throws Exception {
        this.mockMvc.perform(
                get("/books/?title=java")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void shouldFailGettingResponseFromBooksListWhenInvalidArgumentsAreProvided() throws Exception {
        String toShortQueryTitle = "A";

        this.mockMvc.perform(
                get("/books/?title=" + toShortQueryTitle)
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("books.title: size must be between 3 and 100"))
                .andDo(print());
    }

    @Test
    public void shouldFailGettingResponseFromBooksListWhenMissingArgument() throws Exception {
        this.mockMvc.perform(
                get("/books/")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Required parameter 'title' is missing"))
                .andDo(print());
    }

    @Test
    public void shouldReturnOffersListWhenGivenValidQuery() throws Exception {
        this.mockMvc.perform(
                get("/offers/?isbn=9780596003999")
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andDo(print());
    }

    @Test
    public void shouldFailGettingResponseFromOffersListWhenInvalidArgumentsAreProvided() throws Exception {
        String invalidIsbn = "XYZ";

        //invalid isbn
        this.mockMvc.perform(
                get("/offers/?isbn=" + invalidIsbn)
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("offers.isbn: Invalid isbn, it must have 13 digits, for example: 9780596003999"))
                .andDo(print());
    }

    @Test
    public void shouldFailGettingResponseFromOffersListWhenMissingArgument() throws Exception {
        this.mockMvc.perform(
                get("/offers/")
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Required parameter 'isbn' is missing"))
                .andDo(print());
    }
}
