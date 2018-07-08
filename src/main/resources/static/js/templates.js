let searchedBooksRowTemplate = `<div class="row">
            <div class="col-12 mx-auto mt-4">
                <div class="row">
                    <div class="col-2">
                        <img src="{{thumbnail}}" alt="" class="thumbnail">
                    </div>
                    <div class="col-8">
                        <div>Title: <strong>{{title}}</strong></div>
                        <div>Subtitle: {{subtitle}}</div>
                        <div>Authors: {{authors}}</div>
                        <div>Published date: <i>{{publishedDate}}</i></div>
                        <div>{{industryIdentifiers}}</div>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-primary compare-prices" value="{{isbn13}}">
                            Compare prices
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
                        <img src="{{thumbnail}}" alt="" class="thumbnail">
                    </div>
                    <div class="col-8">
                        <div>Seller: <strong>{{seller}}</strong></div>
                        <div>Title: <strong>{{title}}</strong></div>
                        <div>Subtitle: {{subtitle}}</div>
                        <div>Isbn: {{isbn}}</div>
                        <div>Price: {{price}} {{currency}}</div>
                        <div>Shipping: {{shippingCost}} {{shippingCurrency}}</div>
                        <div>Local price with shipment: <b>{{localPriceWithShipment}} {{localCurrency}}</b></div>
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

let loadingDataTemplate = `
    <div class="row">
        <div class="col-2 mx-auto mt-4">
            <div class="loader"></div>
        </div>
    </div>
`;

let errorTemplate = `
    <div class="alert alert-danger" role="alert">
        <div>{{message}}</div>
        <div><i>{{details}}</i></div>
    </div>
`;