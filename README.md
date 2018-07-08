# Books Search

## Description

I'm sharing my recruitment assignment. 

Solution is build with spring framework, and integration tested.
For frontend I used Bootstrap and JQuery. 
Initially I wanted to use Angular2 or React but currently I'm really short on time so 
I picked the solution that will be the fastest to implement for me
and I'm focus on backend.

As you wanted, I used other API's for book searching, because Amazon make problems 
with creating affiliate account to use API, and Apress don't have API.
I used Google Books API and Ebay API.

If you will be on site, you could search books by title, and then chose book (by ISBN)
to compare prices in Google Books Store and Ebay.
At the top of the site (inside yellow box) will be the cheapest book, 
below will be list with other offers. If you click button you will be send to seller site.
List is sorted by local currency price with shipping costs.
You could change local currency in configuration file.


If something is missing or if you just want me to add something just contact me.

## Installing

Just install with Maven and run BooksSearchApplication. 
Ports are left as defaults but that can changed in application.properties. 
Url with the default ports is http://localhost:8080/
