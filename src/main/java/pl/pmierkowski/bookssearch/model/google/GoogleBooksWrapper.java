package pl.pmierkowski.bookssearch.model.google;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBooksWrapper {

    private int totalItems;

    private GoogleBooksItemsWrapper[] items;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public GoogleBooksItemsWrapper[] getItems() {
        return items;
    }

    public void setItems(GoogleBooksItemsWrapper[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GoogleBooksWrapper{" +
                "totalItems=" + totalItems +
                ", items=" + Arrays.toString(items) +
                '}';
    }
}
