# Group 26 - Specification - Phase 1
The main purpose of this project is to create a second hand book platform for UofT students to buy and sell second
hand books. Usually an E-commerce platform limits users to represent only one function - they are either the seller
(store owner) or the buyer (customer). Our application creates a community that solves students' needs to buy affordable
books for their new school term while also satisfying their needs to sell their old textbooks.

### Inventory and Shopping cart for Users
Users can add listings of the books they want to buy to their wishlist. This allows buyers to easily access the listings
of the books they want to buy and monitor their status. Users can also add books to their inventory. This allows sellers
to easily access the books they want to sell when creating listings.

### Profile system
Users in our database system can now have access to their profile which includes their personal information as well as 
the login information. They are also now able to edit their profile, such as changing the address, uoft email address 
as well as the password.

### Interacting with Database
ConsoleUI can print and read the data we type. Until we get
the data from the user, then the controller can decide to display
user or to update student. The controller will use some service
to work with the entity, it can do things like CRUD, create,
read, update, or delete.