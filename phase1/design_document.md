# Group 26 - Design Document - Phase 1

## Solid

#### Single Responsibility Principle
Every class of our project follows the single responsibility principle such that they each have a single responsibility. 
We have isolated complex functionalities to different classes, so that each class only has one reason to change.

#### Open / Closed Principle
When we add new features to our code base, we extend upon the code we already have instead of modifying the 
software entities.

#### Liskov Substitution Principle
In our project, User and Admin classes are child classes of Account class. The objects User and Admin may be substituted 
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
including change username, change password etc.

## Clean Architecture

TODO: Wesley & Tien

## Design Patterns

TODO: Taylan

## Packaging Strategies
TODO: Will

## Major Design Decisions

TODO: Wesley & Tien