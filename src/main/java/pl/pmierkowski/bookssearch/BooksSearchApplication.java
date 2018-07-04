package pl.pmierkowski.bookssearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "pl.pmierkowski.bookssearch")
@SpringBootApplication
public class BooksSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksSearchApplication.class, args);
    }
}
