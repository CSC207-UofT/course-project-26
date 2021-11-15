# Group 26 - Design Document - Phase 1

## Solid

#### Single Responsibility Principle
Every class of our project follows the single responsibility principle such that they each have a single responsibility. 
We have isolated complex functionalities to different classes, so that each class only has one reason to change.

#### Open / Closed Principle
When we add new features to our code base, we extend upon the code we already have instead of modifying the 
software entities.

#### Liskov Substitution Principle
In our project, Usergateway and Admingateway classes are child classes of Gateway class. The objects User and Admin may be substituted 
without altering any of the desired properties of the program.

#### Dependency Inversion Principle
The gateway class is used for interacting with the database by reading and saving information to our files. However, 
this action involves calling instances from use case classes, making the gateway class dependent on use case classes and
thus violating principles of clean architecture. In this case, use cases is more abstract than gateway because use cases
have more use cases while gateway can only be used specifically for one file, and it is more preferred to have something 
more concrete to depend on something more abstract, not the other way around. In order to revert the source code 
dependency, we convert our gateway class into an interface. Then, we pass in the interface to our use case class constructor. Now, even thought it calls a 
method in the gateway class, it is no longer dependent on the main.consoleUI.Gateway class because any gateway class that implements 
the interface will have the method.

#### Interface Segregation Principle
The use case Account manager is implemented as an interface to store the essential features when managing an account,
including change username, change password etc. No realization class is forced to implement irrelevant  methods of an interface.

## Clean Architecture

In our project, we have different layers of clean architecture, and they follow the dependency rule of the clean architecture. 
Our source code dependencies only points inwards. Nothing in the inner circle can know anything at all about something 
in an outer circle.

The Account, Admin, Book, Listing and User are our 
entity class, and they are independent. They store the interfaces that we need for each different class. You can access the Entity classes
directly from our User case classes, which are AccountManager, AdminManager, 
BookManager, ListingManager, and UserManager. The User case classes get the information from the Entity class and manage
all the data from the Entity class.

The Controller classes retrieves and store data from the database. For example, they take the information directly from 
our user, and returns information back to the User based on our Use case classes. It interacts with our use case layer
to execute request form the User. 


## Design Patterns

We implemented the Builder design pattern in our project in Book and BookManager classes. As the builder, 
we used the Book class. And as the director, we used the BookManager class.
The Book class knows the specifics about the book and it creates the necessary book with the given values. 
And when the user leaves some of the values blank and doesn’t put in each detail about the book like its size, 
its weight, etc., The BooksManager generates a Book without those details, so that the user can provide less details 
about the book when they want. This is necessary as a seller may not know every small detail about the book they are 
selling.

## Packaging Strategies
The packaging strategy we use for our UofT's online second-hand book store is packaging by the layers of the clean Architecture.
We separate java files of different layer into different packages. For instance, we have the ConsoleUI, Controller, User cases and Entities
packages that contain corresponding layer of java file. Since our program consists of many classes that belong to different categories
but the same layer in clean architecture, we also divided some layers by its categories. For example, even though controller
and Gateway belong to the same layer, we separate them into its own packages, so that the files for gateways and controllers will not be
that overcrowded and disturbing to find a certain file. Using the packaging by layer strategy not only contribute to our clean packages organization which 
could allow us to locate the class we want efficiently but also help us avoid some violations of the clean architecture that we might
have along the way.

## Major Design Decisions

Seller and Buyer classes are originally the child class for User Class. However, we believe that a user can either be a 
seller or a buyer, so User class and Admin class are now the child classes for Account class. 