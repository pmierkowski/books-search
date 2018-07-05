jQuery(document).ready(function () {
    let template = `<div class="row">
            <div class="col-12 mx-auto mt-4">
                <div class="row">
                    <div class="col-2">
                        <img src="{{thumbnail}}" alt="">
                    </div>
                    <div class="col-8">
                        <div><strong>{{title}}</strong></div>
                        <div>{{subtitle}}</div>
                        <div>{{authors}}</div>
                        <div>{{publishedDate}}</div>
                        <ul>
                            <li>{{industryIdentifiers}}</li>
                        </ul>
                    </div>
                    <div class="col-2">
                        <button type="button" class="btn btn-primary"><i class="fa fa-search"></i> Compare prices
                        </button>
                    </div>
                </div>
            </div>
        </div>`;

    $('#search-books-btn').on('click', function(){
        let query = $('#search-query').val();
        $('#books-list').html('Loading data ...');

        $.getJSON("http://localhost:8080/search-books?title=" + query, function (data) {
            $('#books-list').empty();

            $.each(data, function (key, val) {
                let row = '';
                row = template.replace('{{title}}', val.title ? val.title : '');
                row = row.replace('{{thumbnail}}', val.imageLinks ? val.imageLinks.thumbnail : '');
                row = row.replace('{{subtitle}}', val.subtitle ? val.subtitle : '-');
                row = row.replace('{{authors}}', val.authors ? val.authors.join(', ') : '');
                row = row.replace('{{publishedDate}}', val.publishedDate ? val.publishedDate : '-');
                row = row.replace('{{industryIdentifiers}}', val.industryIdentifiers ? JSON.stringify(val.industryIdentifiers) : '');

                $('#books-list').append(row);
            });
        });
    });
});