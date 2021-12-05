# Group 26 - Design Document - Phase 2

## Specification
The main purpose of this project is to create a second hand book platform for UofT students to buy and sell second
hand books. Usually an E-commerce platform limits users to represent only one function - they are either the seller
(store owner) or the buyer (customer). Our application creates a community that solves students' needs to buy affordable
books for their new school term while also satisfying their needs to sell their old textbooks.

#### Inventory and Shopping cart for Users
Users can add listings of the books they want to buy to their wishlist. This allows buyers to easily access the listings
of the books they want to buy and monitor their status. Users can also add books to their inventory. This allows sellers
to easily access the books they want to sell when creating listings.

#### Profile system
Users in our database system can now have access to their profile which includes their personal information as well as
the login information. Users can now edit their first name, last name, and address as well. The information will be 
updated immediately. 

#### Database configuration (H2 Database)
H2 database is an open-source database written in Java programming language which supports querying data in standard
SQL. It is very much lightweight and its JAR file is only 1.5 MB in size. It also also provides a web interface called
H2 Console to see the data.

The best thing about using an in-memory database is that we don’t have to do any configuration at all. We've' added
a single property to the application file which enable the H2 console. Therefore, we can access the Web UI for our 
in-memory database via the following link:
http://localhost:8080/h2-console.
This URL is reachable only when our application is in a running mode. We will have a look at this console once we run 
our project.

#### H2 Database with Spring Boot
Java Spring Boot (Spring Boot) is a tool that makes developing web application and microservices with Spring Framework 
faster and easier. It provides a tool that allows you to set up a Spring-based application with minimal
configuration and setup. With it, developers like us can get started quickly without losing time on preparing and 
configuring their Spring application.

So, how does H2 and Spring Boot combination work? Spring Boot is intelligent, it looks at the entities and creates the
database and the tables. Spring Boot Application connect to the database h2 by Spring Boot Auto Configuration. It 
attempts to automatically configure your Spring application based on the jar dependencies that we've added.

#### Data Access Layer interface and the ConsoleUI
To access the database, we will be defining a simple JPA interface which provides its own helper functions. Once We run 
our application with a command-line runner, it will call the functions we defined from the JPA Repository interface 
, and  we will be able to see a simple output in our terminal.

It is important to note that the above UI console is accessible only for the time this application is running. Also, 
after the application has stopped, this console won’t be reachable anymore.

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

# TODO: Annie and Grace

## Design Patterns

We implemented the Builder design pattern in our project in Book and BookManager classes. As the builder, 
we used the Book class. And as the director, we used the BookManager class.
The Book class knows the specifics about the book and it creates the necessary book with the given values. 
And when the user leaves some of the values blank and doesn’t put in each detail about the book like its size, 
its weight, etc., The BooksManager generates a Book without those details, so that the user can provide less details 
about the book when they want. This is necessary as a seller may not know every small detail about the book they are 
selling.

# TODO: Annie

## Use of Github Features
We took advantage of a variety of features that Github offers for version control and collaborating as a team. We used 
features like branching, creating pull requests where we review each others code and resolve merge conflicts.

#### Branching
Each of us work on our own feature branch to develop new features to our project, providing us space to 
make changes without affecting the main branch. Whenever we make a completed change, we write concise but informative 
commit messages to help ourselves and future contributors to understand what changes the commit contains. After we 
commit our changes, we push our work to remote storage, so we can access our work from any device and our team can see 
each of our work, answer questions, and make suggestions.

#### Creating Pull Requests & Conducting Code Reviews
After we commit and push our feature branch to remote, we create a pull request by including a summary of the changes 
and what problem they solve. This feature allows us to ask each other for feedback on our changes before we merge into
our main branch. \

Pull request review is valuable for us in identifying potential issues in each other's code - we are 
able to comment on specific lines that cause problems, and everyone is able to see. It helps to address issues before
merging to main, and it allows everyone to be aware of the added code and problems it may cause, so other members can 
avoid repeating the same problem with their features.

#### Resolving Merge Conflicts
Sometimes multiple members push changes to the same code which causes merge conflicts. We utilize the feature of 
resolving merge conflicts in Github to select the code we wish to keep before we merge into main. This feature gives us 
flexibility to create changes on any files in our project without the need to worry that the changes may conflict with 
another member's and will get lost during version control.


## Refactoring and Code Smells

# TODO: Will & Tien

## Testing
# TODO: Taylan

## Code Style and Documentation
# TODO: Taylan


## Code Organization / Packaging Strategies
The packaging strategy we use for our UofT's online second-hand book store is packaging by the layers of the clean Architecture.
We separate java files of different layer into different packages. For instance, we have the ConsoleUI, Controller, User cases and Entities
packages that contain corresponding layer of java file. Since our program consists of many classes that belong to different categories
but the same layer in clean architecture, we also divided some layers by its categories. For example, even though controller
and Gateway belong to the same layer, we separate them into its own packages, so that the files for gateways and controllers will not be
that overcrowded and disturbing to find a certain file. Using the packaging by layer strategy not only contribute to our clean packages organization which 
could allow us to locate the class we want efficiently but also help us avoid some violations of the clean architecture that we might
have along the way.


## Accessibility

# TODO: Wesley

## Major Design Decisions

Seller and Buyer classes are originally the child class for User Class. However, we believe that a user can either be a 
seller or a buyer, so User class and Admin class are now the child classes for Account class. The second major decision
will be we choose to use Spring Boot and command line to present our system. Spring Boot is an open source Java-based 
framework used to create a micro Service.

These major design decisions lead us to have four strategy 
design pattern. The first one is MVC (model, view, controller).
Then we have the builder. Next is the spring boot. Lastly, is 
the dependency injection (autowire) and interface (repository).


## Progress Report

#### Individual Responsibility

* Annie: worked together with Grace on Entity classes, Gateway classes, SOLID principle
* Grace: worked together with Annie on Entity classes, Gateway classes, SOLID principle, contributed to specification, testing
* Taylan: worked on the builder pattern for Book class, worked on book, listing classes and documenting our design patterns
* Tien: worked together with Wesley and Will on Clean Architecture, Major Design Decisions, worked with Will on UI and controllers, wrote specification
* Wesley: worked together with Tien on Clean Architecture and Major Design Decisions, and worked on the Usercase classes.
* Will: worked together with Tien on UI's and controllers, and worked on the Packaging strategy.


#### Open Questions
* already answered during presentation

#### What has worked well so far
* Our classes organization is clean. 