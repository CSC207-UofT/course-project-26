package main.consoleUI;

import com.google.common.collect.Lists;
import main.controller.ListingPortalController;
import main.entity.Book;
import main.entity.User;
import main.service.BookService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ListingPortal {

    @Autowired
    ListingPortal listingPortal;

    @Autowired
    ListingPortalController listingPortalController;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    private void printAskForCommandMessage() {
        System.out.print(" Enter command (buy,sell,exit)=> ");
    }
    private void printAskForCommandMessage2() {
        System.out.print(" Enter command (1,2,3,4,5,6,7,8,9,0)=> ");
    }

    public void ListingUser(Scanner scanner, User user) {
        System.out.print("\n\n=== BOOK PORTAL ===\" +" +
                "\n1) Type 'buy' to view the list and buy the books you want" +
                "\n2) Type 'sell' to sell books" +
                "\n3) Type 'exit' to exit " +
                "\n==============");
        printAskForCommandMessage();
        String command = scanner.nextLine();

        while (!command.equals("exit")) {
            if (command.equals("buy")){
                List<Book> books = listingPortalController.getAllBooks();
                List<List<Book>> booksPartitions = Lists.partition(books, 3);

                int page = 0;

                while (!command.equals("exit")) {
                    if (page < booksPartitions.size() && page >= 0) {

                        Integer page_number = page + 1;

                        System.out.print("\n\n=== Page" + page_number + "===\" +" +
                                getBookMessage(booksPartitions.get(page)) +
                                "\n9) Type 9 to go to the previous page" +
                                "\n0) Type 0 to go to the next page" +
                                "\nExit) Type 'exit' to go back to the BOOK PORTAL\n");

                        printAskForCommandMessage2();
                        command = scanner.nextLine();

                        switch (command) {
                            case "1":
                                String username1 = booksPartitions.get(page).get(0).getUser();
                                User user1 = userService.getUserByUsername(username1);
                                System.out.println("\n====================" + "\n" +
                                        "Seller's Name: " + user1.getFirstName() + " " + user1.getLastName() + "\n" +
                                        "Seller's Email: " + user1.getEmail() + "\n" +
                                        "Seller's Address: " + user1.getAddress() + "\n" +
                                        "====================");
                                break;
                            case "2":
                                String username2 = booksPartitions.get(page).get(1).getUser();
                                User user2 = userService.getUserByUsername(username2);
                                System.out.println("\n====================" + "\n" +
                                        "Seller's Name: " + user2.getFirstName() + " " + user2.getLastName() + "\n" +
                                        "Seller's Email: " + user2.getEmail() + "\n" +
                                        "Seller's Address: " + user2.getAddress() + "\n" +
                                        "====================");
                                break;
                            case "3":
                                String username3 = booksPartitions.get(page).get(2).getUser();
                                User user3= userService.getUserByUsername(username3);
                                System.out.println("\n====================" + "\n" +
                                        "Seller's Name: " + user3.getFirstName() + " " + user3.getLastName() + "\n" +
                                        "Seller's Email: " + user3.getEmail() + "\n" +
                                        "Seller's Address: " + user3.getAddress() + "\n" +
                                        "====================");
                                break;
                            case "9":
                                page--;
                                break;
                            case "0":
                                page++;
                                break;
                            case "exit":
                                break;
                            default:
                                printAskForCommandMessage2();
                                command = scanner.nextLine();
                        }
                    } else {
                        System.out.print(" Error happen ");
                        break;
                    }
                }
            } else if(command.equals("sell")){
                System.out.print(" Enter the name of the book => ");
                String book_name = scanner.nextLine();

                System.out.print(" Enter your desired price for the book => ");
                double book_price = Double.parseDouble(scanner.nextLine());

                System.out.print(" Enter the name of the author of the book => ");
                String book_author = scanner.nextLine();
                listingPortalController.sell(user.getUsername(), book_price, book_name, book_author);
            } else {
                System.out.println("No such command!");
            }

            printAskForCommandMessage();
            command = scanner.nextLine();
        }

    }

    private String getBookMessage(List<Book> books) {
        String message = "";
        for (int i = 0; i < books.size(); i++) {
            Integer number = i + 1;

            message += ("\n" + number + ") " + books.get(i).toString());
        }

        return message;
    }

}
