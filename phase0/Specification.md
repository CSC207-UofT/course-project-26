# Specification for UofT Secondhand Book MarketPlace

The main purpose of this project is to create a second hand book platform for UofT students to buy and sell second 
hand books. Usually an E-commerce platform limits users to represent only one function - they are either the seller 
(store owner) or the buyer (customer). Our application creates a community that solves students' needs to buy affordable 
books for their new school term while also satisfying their needs to sell their old textbooks. 

There are two child classes of the User class, they are the Users.Seller and the Users.Buyer. Users.Seller can post unwanted books onto
the web platform, specially, create a Book.Book with instances such as, the name, the price, the picture of the cover, etc,
onto the platform. While the Users.Buyer can then search for the books that he wants, if there is one, then the platform will
send notification, including other person’s email, to both person.

The Use Case Class Usermanagement.Register would check if user is already registered and
check if the given password matches the correct password. Usermanagement.Login allows user to login the web.

## Key Features 

### Posting a Listing
A seller can create a posting that includes information of his unwanted book. The listing will be added to the platform's
listings page, where everyone can browse it. The seller can edit the listing anytime. He can change the status 
to "Sold" to remove the listing from the platform listings page.

### Searching for a Book
Users can search for a book on the listings page to access a listing quicker. In the future, we may also add the ability
to search a book using the book's author, publisher etc.

### Sorting Listing by Price
On the platform listings page, users are able to sort the listing by price (either from low to high or high to low).

### Wishlist for Buyers
Buyers can add listings of the books they want to buy to their wishlist. This allows buyers to easily access the listings
of the books they want to buy and monitor their status.

