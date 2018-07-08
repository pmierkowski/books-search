const REST_API_ENDPOINT = "http://localhost:8080/";
const REQUIRED_TYPE = "ISBN_13";

jQuery(document).ready(function () {
    $('#search-books-btn').on('click', function () {
        Page.searchBooks()
    });
    $('#search-query').on('keypress', function (event) {
        //bind enter
        if (event.which == 13) {
            Page.searchBooks();
        }
    });
});

class Page {
    constructor() {
    };

    static searchBooks() {
        let query = $('#search-query').val();

        Page.showLoader();

        $.ajax({
            url: REST_API_ENDPOINT + "books/?title=" + query
        }).done(function (data) {
            $('#books-list').empty();

            $.each(data, function (key, val) {
                $('#books-list').append(Page.injectVariablesToSearchedBooksRowTemplate(val));
            });

            $('.compare-prices').on('click', function () {
                Page.getOffers($(this).val());
            });
        }).fail(function (jqxhr, textStatus, error) {
            Page.showError(jqxhr)
        });
    };

    static showError(jqxhr) {
        var err = eval("(" + jqxhr.responseText + ")");

        let html = errorTemplate.replace('{{message}}', err.message);
        html = html.replace('{{details}}', err.details);

        $('#books-list').empty();
        $('#books-list').html(html);
    }

    static getOffers(isbn) {
        Page.showLoader();

        $.ajax({
            url: REST_API_ENDPOINT + "offers/?isbn=" + isbn
        }).done(function (data) {
            $('#books-list').empty();

            $('#books-list').append(Page.injectVariablesToComparePriceRowTemplate(data.bestOffer, true));
            $.each(data.otherOffers, function (key, val) {
                $('#books-list').append(Page.injectVariablesToComparePriceRowTemplate(val, false));
            });
        }).fail(function (jqxhr, textStatus, error) {
            Page.showError(jqxhr)
        });
    };

    static showLoader() {
        $('#books-list').empty();
        $('#books-list').html(loadingDataTemplate);
    }

    static injectVariablesToSearchedBooksRowTemplate(val) {
        let row = '';
        row = searchedBooksRowTemplate.replace('{{title}}', val.title ? val.title : '');
        row = row.replace('{{thumbnail}}', val.imageLinks ? val.imageLinks.thumbnail : '');
        row = row.replace('{{subtitle}}', val.subtitle ? val.subtitle : '-');
        row = row.replace('{{authors}}', val.authors ? val.authors.join(', ') : '');
        row = row.replace('{{publishedDate}}', val.publishedDate ? val.publishedDate : '-');
        row = row.replace('{{industryIdentifiers}}', val.industryIdentifiers.map(function (x) {
            return x.type + ": " + x.identifier;
        }));
        row = row.replace('{{isbn13}}', val.industryIdentifiers.find(function (x) {
            return x.type === REQUIRED_TYPE;
        }).identifier);

        return row;
    };

    static injectVariablesToComparePriceRowTemplate(val, isBestPrice) {
        let row = '';
        row = comparePricesRowTemplate.replace('{{title}}', val.title);
        row = row.replace('{{seller}}', val.seller);
        row = row.replace('{{thumbnail}}', val.thumbnailUrl);
        row = row.replace('{{subtitle}}', val.subtitle != null ? val.subtitle : '-');
        row = row.replace('{{isbn}}', val.isbn);
        row = row.replace('{{price}}', val.price != null ? val.price : '-');
        row = row.replace('{{currency}}', val.currency != null ? val.currency : '');
        row = row.replace('{{shippingCost}}', val.shippingCost != null ? val.shippingCost : '-');
        row = row.replace('{{shippingCurrency}}', val.shippingCurrency != null ? val.shippingCurrency : '');
        row = row.replace('{{localPriceWithShipment}}', val.localPriceWithShipment != null ? val.localPriceWithShipment : 'Not for selling');
        row = row.replace('{{localCurrency}}', val.localCurrency != null && val.localPriceWithShipment != null ? val.localCurrency : '');
        row = row.replace('{{buyUrl}}', val.buyUrl);
        row = row.replace('{{bestPrice}}', isBestPrice === true ? 'best-price' : '');
        row = row.replace('{{buttonText}}', val.forSale == false ? 'Show book' : 'Buy book');

        return row;
    }
}