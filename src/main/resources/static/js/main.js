let searchedBooksRowTemplate = `<div class="row">
            <div class="col-12 mx-auto mt-4">
                <div class="row">
                    <div class="col-2">
                        <img src="{{thumbnail}}" alt="">
                    </div>
                    <div class="col-8">
                        <div>Title: <strong>{{title}}</strong></div>
                        <div>Subtitle: {{subtitle}}</div>
                        <div>Authors: {{authors}}</div>
                        <div>Published date: {{publishedDate}}</div>
                        <div>{{industryIdentifiers}}</div>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-primary compare-prices" value="{{isbn13}}">
                            <i class="fa fa-search"></i> Compare prices
                        </button>
                    </div>
                </div>
            </div>
        </div>`;

let comparePricesRowTemplate = `
        <div class="row {{bestPrice}}">
            <div class="col-12 mx-auto mt-4">
                <div class="row">
                    <div class="col-2">
                        <img src="{{thumbnail}}" alt="">
                    </div>
                    <div class="col-8">
                        <div>Seller: <strong>{{seller}}</strong></div>
                        <div>Title: <strong>{{title}}</strong></div>
                        <div>Subtitle: {{subtitle}}</div>
                        <div>Isbn: {{isbn}}</div>
                        <div>Price: {{price}} {{currency}}</div>
                        <div>Shipping: {{shippingCost}} {{shippingCurrency}}</div>
                        <div>Local price with shipment: {{localPriceWithShipment}} {{localCurrency}}</div>
                    </div>
                    <div class="col-2">
                        </button>
                        <a class="btn btn-primary" href="{{buyUrl}}" role="button" target="_blank">
                             {{buttonText}}
                        </a>
                    </div>
                </div>
            </div>
        </div>
    `;

function injectVariablesToComparePriceRow(val, isBestPrice){
    let row = '';
    row = comparePricesRowTemplate.replace('{{title}}', val.title);
    row = row.replace('{{seller}}', val.seller);
    row = row.replace('{{thumbnail}}', val.thumbnailUrl);
    row = row.replace('{{subtitle}}', val.subtitle != null ? val.subtitle : '');
    row = row.replace('{{isbn}}', val.isbn);
    row = row.replace('{{price}}', val.price != null ? val.price : 'Not for buying');
    row = row.replace('{{currency}}', val.currency != null ? val.currency : '');
    row = row.replace('{{shippingCost}}', val.shippingCost != null ? val.shippingCost : '');
    row = row.replace('{{shippingCurrency}}', val.shippingCurrency != null ? val.shippingCurrency : '');
    row = row.replace('{{localPriceWithShipment}}', val.localPriceWithShipment != null ? val.localPriceWithShipment : '');
    row = row.replace('{{localCurrency}}', val.localCurrency != null ? val.localCurrency : '');
    row = row.replace('{{buyUrl}}', val.buyUrl);
    row = row.replace('{{bestPrice}}', isBestPrice === true ? 'best-price' : '');
    row = row.replace('{{buttonText}}', val.forSale == false ? 'Show book (not for selling)' : 'Buy book');

    return row;
}

jQuery(document).ready(function () {
    const REQUIRED_TYPE = "ISBN_13";

    $('#search-books-btn').on('click', function () {
        let query = $('#search-query').val();
        $('#books-list').html('Loading data ...');

        $.getJSON("http://localhost:8080/books/?title=" + query, function (data) {
            $('#books-list').empty();

            $.each(data, function (key, val) {
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

                $('#books-list').append(row);
            });

            $('.compare-prices').on('click', function () {
                let isbn = $(this).val();
                $('#books-list').empty();
                $('#books-list').html('Loading data ...');

                $.getJSON("http://localhost:8080/offers/?isbn=" + isbn, function (data) {
                    $('#books-list').empty();

                    $('#books-list').append(injectVariablesToComparePriceRow(data.bestOffer, true));
                    $.each(data.otherOffers, function (key, val) {
                        $('#books-list').append(injectVariablesToComparePriceRow(val, false));
                    });
                });
            });
        });
    });
});